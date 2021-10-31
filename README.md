# Linked-List-2

## Problem1 (https://leetcode.com/problems/binary-search-tree-iterator/)

# Time Complexity=O(1)
# Space Complexity=O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack=[]
        self.root=root
        self.leftinorder(self.root)
        
    def leftinorder(self,root):
        while root:
            self.stack.append(root)
            root=root.left
    def next(self) -> int:
        a=self.stack.pop()
        if a.right:
            self.leftinorder(a.right)
        return a.val
       
    def hasNext(self) -> bool:
        if len(self.stack)!=0:
            return True
        else:
            return False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
## Problem2 (https://leetcode.com/problems/reorder-list/)

# Time Complexity=O(n)
# Space Complexity=O(1)


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
        slow=head
        fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        mid=slow
        def reverse(h):
            if not h or not h.next:
                return h
            p=reverse(h.next)
            h.next.next=h
            h.next=None
            return p
        head2=reverse(mid.next)
        slow.next=None
        while head2:
            temp=head.next
            head.next=head2
            head2=head2.next
            head.next.next=temp
            head=temp
            
            
        
            
        

## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

# Time Complexity=O(1)
# Space Complexity=O(1)
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        if not curr_node or not curr_node.next:
            return
        curr_node.data=curr_node.next.data
        curr_node.next=curr_node.next.next

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

# Time Complexity=O(n)
# Space Complexity=O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        l1,l2=0,0
        h1=headA
        h2=headB
        while h1:
            l1+=1
            h1=h1.next
        while h2:
            l2+=1
            h2=h2.next
        while l1>l2:
            headA=headA.next
            l1-=1
        while l2>l1:
            headB=headB.next
            l2-=1
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        return headA
        
        
