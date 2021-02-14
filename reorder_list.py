# O(N) TIME AND O(1) SPACE WHERE N IS LEN(lIST)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        if head is None:
            return None
        """
        Do not return anything, modify head in-place instead.
        """
        p1 = head
        p2 = head
        while p2 is not None and p2.next is not None:
            p1 = p1.next
            p2 = p2.next.next
            
         
        p2 = self.reverse(p1.next)
        p1.next = None
        p1 = head   
        # prev = None
        
        while p1 is not None and p2 is not None:
            p3 = p1.next
            p4 = p2.next
            
            p1.next = p2
            p1 = p3
            

            p2.next = p1
            p2 = p4
   
    
    def reverse(self,head):
        p1 = None
        p2 = head
        while p2 is not None:
            p3 = p2.next
            p2.next = p1
            p1 = p2
            p2 = p3
        return p1