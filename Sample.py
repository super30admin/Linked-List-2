
## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

// Implemented the BST iterator using an iterative in-order traversal with a stack, achieving the optimal O(h) space complexity (where h = tree height):

// Initialization: Push all leftmost nodes onto the stack (smallest element on top)
// next(): Pop the top node (current smallest), then process its right subtree's leftmost path
// hasNext(): Check if stack is non-empty

// Time Complexity:
// next(): Amortized O(1) (each node pushed/popped once)
// hasNext(): O(1)
// Space Complexity: O(h) (stack stores at most one path from root to leaf)
// The key insight is delaying traversal - only process nodes as needed instead of precomputing everything.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)

    def dfs(self,root):
        while root:
            self.st.append(root)
            root = root.left

    def next(self) -> int:
        nextE = self.st.pop()
        self.dfs(nextE.right)
        return nextE.val

    def hasNext(self) -> bool:
        return len(self.st) != 0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()




## Problem2 (https://leetcode.com/problems/reorder-list/)

// Implemented the 3-step in-place linked list reordering:

// 1. Find midpoint using slow/fast pointers (slow ends at middle)
// 2. Reverse second half starting from midpoint (prev becomes new head of reversed half)
// 3. Merge alternately: Interleave nodes from first half (`head`) and reversed second half (`prev`) until second half is exhausted

// - Time Complexity: O(N)   
// - Space Complexity: O(1) (only pointers used)

// Reversing the second half lets you "pop" nodes from the end in O(1) time during merging. 
// The loop condition while second.next ensures we stop when the shorter half (second half) is fully merged.

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
        if not head:
            return

        # find mid
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse mid to last
        first = 0
        prev = None
        curr = slow
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        # join lists
        first = head
        second = prev
        while second.next:
            temp = first.next
            first.next = second
            first = temp
            
            temp = second.next
            second.next = first
            second = temp
        

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

// Approach:
// Since you can't access the previous node (singly linked list), you simulate deletion by copying the next node's data and removing the next node instead.
// Limitation: Doesn't work if the node to delete is the last node (but the problem guarantees it's not).
//              del.data              =  del.next.data
//         10 ->  20 replace with 4            4           30

              
//              del.next =  del.next.next
//         10 -> 4                4           30
//               |                             ^
//               |_____________________________|    


// - Time Complexity: O(1)   
// - Space Complexity: O(1)


'''
    Your task is to delete the given node from
	the linked list, without using head pointer.
	
	Function Arguments: node (given node to be deleted) 
	Return Type: None, just delete the given node from the linked list.

	{
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    def __init__(self):
        self.head = None
        
    def deleteNode(self, del_node):
        # code here
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next



## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

// Implemented the length-alignment approach to find the intersection node of two linked lists.
// By aligning the starting positions, you ensure both pointers will reach the intersection node (if it exists) at the same time. 

// Calculate lengths of both lists (lenA and lenB)
// Advance the longer list's pointer by the difference in lengths so both pointers start at the same distance from the end
// Move both pointers together until they either meet (intersection found) or both become None (no intersection)
// Time Complexity: O(m + n) — two passes to get lengths + one pass to find intersection
// Space Complexity: O(1) — only uses pointers


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        curr = headA
        while curr:
            lenA += 1
            curr = curr.next

        lenB = 0
        curr = headB
        while curr:
            lenB += 1
            curr = curr.next

        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        
        while headA != headB:
            headA = headA.next
            headB = headB.next
                
        return headA
        