# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    
    def find_mid(self,node) :
        s = node 
        f = node.next
        while f and f.next :
            f = f.next.next
            s = s.next
        return s
    
    def reverse(self,node) :
        prev = None
        current = None
        nxt = node
        while nxt :
            prev = current
            current = nxt
            nxt = nxt.next
            current.next = prev

        return current
    
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head :
            return None
        
        
        
        mid = self.find_mid(head)

        head2 = mid.next
        head1 = head
        mid.next = None
      
        head2 = self.reverse(head2)
            
        while head1 and head2 :
            temp = head2.next
            head2.next = head1.next
            head1.next = head2
            head2 = temp
            head1 = head1.next.next
        
        return head
             
        
        
