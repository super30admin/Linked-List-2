# Time Complexity - O(n)
# Space Complexity - O(1)
#Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        s, f = head, head.next
        
        while f and f.next:
            s = s.next
            f = f.next.next
        temp = s
        s = s.next 
        temp.next = None
        
        curr = head
        s1 = head.next
        s2 = self.reverse(s)
        bool = True
        while s1 and s2:
            if bool:
                curr.next = s2
                curr = curr.next
                s2 = s2.next
                bool = False
            else:
                curr.next = s1
                curr = curr.next
                s1 = s1.next
                bool = True
        
        curr.next = s1 if s1 else s2
        
        return head
    
    def reverse(self, head):
        if not head or not head.next:
            return head
        curr = head.next
        head.next = None
        prev = head
        
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp 
        
        head = prev
        return head
        