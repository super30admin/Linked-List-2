#Time Complexity : O(N)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

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
        slow = head
        fast = head
        #first find mid of linked list
        while fast!=None and fast.next!=None:
            slow = slow.next
            fast = fast.next.next
            
        #reverse second part of linkedlist    
        rev = self.reverse(slow.next)
        #merging two lists
        slow.next = None
        slow = head
        while rev!=None:
            temp = slow.next
            slow.next = rev
            rev = rev.next
            slow.next.next = temp
            slow = temp
                
    def reverse(self,head):
        
        prev = None
        curr = head
        while curr!=None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        return prev
        
    