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
        if head is None or head.next is None:
            return
        
        slow, fast = head, head
        
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        fast = self.reverse(slow.next) 
        slow.next = None
        slow = head
        curr = ListNode()
        
        while fast is not None:
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = curr
            slow = curr
    
    
    def reverse(self, head: ListNode):
        
        prev = None
        curr = head
        fast = head.next
        
        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        curr.next = prev
        
        return curr
    
#  approach is to break the problem - first find middle, second is to make reverse second half
#  third is to manipulate connections as required.
    
            
                
        
        
            
        

        
