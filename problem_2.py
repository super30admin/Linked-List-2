# Time O(N)
# Space O(1)
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
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        sec_h = self.reverse(slow.next)
        slow.next = None 
        fir_h = head 
        while sec_h is not None:
            tmp1 = fir_h.next
            tmp2 = sec_h.next 
            fir_h.next = sec_h 
            sec_h.next = tmp1 
            fir_h = tmp1 
            sec_h = tmp2
        
    def reverse(self,head):
        curr = head
        prev = None 
        temp = None 
        while curr:
            temp = curr.next
            curr.next = prev 
            prev = curr 
            curr = temp 
        return prev
        