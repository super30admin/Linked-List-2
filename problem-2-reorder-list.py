"""
Problem: https://leetcode.com/problems/reorder-list/

Approach:

1. find the middle of the linked list
2. reverse the list after the middle element
3. merge the two lists

"""

# Time Complexity : O(N) where N is the length of the list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def reverseList(self,head):
        prev= None
        cur = head
        while(cur!=None):
            nextNode = cur.next
            cur.next =prev
            prev=cur
            cur = nextNode
        return prev
    
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if(head==None):
            return None
        
        # Find middle
        slow = head
        fast = head
        while(fast.next!=None and fast.next.next!=None):
            slow = slow.next
            fast = fast.next.next    
        
        # Reverse from middle element
        headB = self.reverseList(slow.next)
        
        # point headA and headB to start of 2 lists
        slow.next = None
        headA= head
        
        # Merge the 2 lists
        while(headB!=None):
            cur = headA.next
            headA.next = headB
            headB=headB.next
            headA.next.next = cur
            headA= cur
        
        return head
        
        
        