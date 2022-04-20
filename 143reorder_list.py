# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

"""
use slow and fast to arrive at the mid point 
reverse the second half of the list 
merge the 2 halves 
"""

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next == None:
            return head 
        
        def reverse(head):
            prev = None 
            curr = head 
            lead = head.next 
            
            while lead!=None:
                tmp1 = lead.next 
                lead.next = curr 
                curr.next = prev 
                prev = curr 
                curr = lead 
                lead = tmp1
                
            curr.next = prev 
            return curr 
        
        
        secondList = None 
        slow = head 
        fast = head 
                
        while fast.next!=None and fast.next.next!=None:
            slow = slow.next 
            fast = fast.next.next 
            
        # print("mid =", slow.val)
        secondList = slow 
        mid = reverse(slow.next)
        slow.next =None # break the list 
        slow = head 
        
        while mid!=None:
            tmp1 =slow.next 
            tmp2 = mid.next
            
            slow.next = mid
            slow.next.next = tmp1 
            
            slow = tmp1
            mid = tmp2
            
        return head 
            
        