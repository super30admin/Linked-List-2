# Time Complexity : O(N) 
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None:
            return
        #find mid
        
        slow = head
        fast = head
        
        #to handle odd and even length
        while(fast.next!=None and fast.next.next!=None):
            slow = slow.next
            fast = fast.next.next
        
        #reverse LL from mid+1
        fast = self.reverseLL(slow.next)
        slow.next = None
        slow = head
        
        #merge LL
        while fast!=None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
            
        
        
    def reverseLL(self,head):
        if head==None or head.next==None:
            return head
        prev = None
        cur = head
        fast = head.next
        
        while(fast!=None):
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
        cur.next = prev
        return cur
        
        
        
            
            