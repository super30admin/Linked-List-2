// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

// Your code here along with comments explaining your approach
Time complexity:
The constructor will take O(h) time where h is the height of the tree. The hasNext() and next() method will take O(1) time.

Space complexity:
The space required by the stack is O(h).
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left
    
    def next(self) -> int:
        node = self.stack.pop()
        if node.right:
            current = node.right
            while current:
                self.stack.append(current)
                current = current.left
        return node.val
    
    def hasNext(self) -> bool:
        return len(self.stack) > 0

### Problem2 (https://leetcode.com/problems/reorder-list/)
# Time Complexcity: O(n)
# Space complexcity : O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
    if not head or not head.next:
            return
        
        # Step 1: Find the middle of the linked list
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Step 2: Reverse the second half of the linked list
        curr, prev = slow.next, None
        slow.next = None # set the next of the slow to None to break the link
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        second_half = prev
        
        # Step 3: Merge the first half and the reversed second half of the linked list
        first_half = head
        while first_half and second_half:
            temp1, temp2 = first_half.next, second_half.next
            first_half.next = second_half
            second_half.next = temp1
            first_half, second_half = temp1, temp2
### Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
# TC: O(m+n)
# Space complexcity : O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Find lengths of linked lists
        lenA, lenB = 0, 0
        nodeA, nodeB = headA, headB
        while nodeA:
            lenA += 1
            nodeA = nodeA.next
        while nodeB:
            lenB += 1
            nodeB = nodeB.next
        
        # Calculate difference in lengths
        diff = abs(lenA - lenB)
        if lenA > lenB:
            # Move pointer of A ahead
            while diff > 0:
                headA = headA.next
                diff -= 1
        else:
            # Move pointer of B ahead
            while diff > 0:
                headB = headB.next
                diff -= 1
        
        # Traverse both linked lists in parallel
        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        
        # No intersection found
        return None