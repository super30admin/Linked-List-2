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
        
        if not head or not head.next:
            return
        
        #Find middle
        middle = self.find_middle(head)
        
        #Reverse list from middle to end        
        fast = self.reverse(middle.next)
        middle.next = None
        
        #Merge        
        slow = head
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    
    def find_middle(self,h):
        
        slow,fast = h,h        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            
        return slow
        
    def reverse(self,head):
        
        prev, current, fast = None, head, head.next
        while fast:            
            current.next = prev
            prev = current
            current = fast
            fast = fast.next
        
        current.next = prev        
        return current
