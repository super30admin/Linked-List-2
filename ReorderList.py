# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity => O(N)
# Space Complexity => O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
           #part-1
        p1, p2 = head, head
        while(p2.next is not None and p2.next.next is not None):
            p1 = p1.next
            p2 = p2.next.next
        prev = p1
        mid = p1.next
        p2 = mid
        prev.next = None
        before = None
        while(p2 is not None):
            after = p2.next
            p2.next = before
            before = p2
            p2 = after
        mid = before
        start = head
        while(mid is not None):
            temp = start.next
            start.next = mid
            mid = mid.next
            start.next.next = temp
            start = temp
            
    
        
        
        
                
                
            
        
        
        
        