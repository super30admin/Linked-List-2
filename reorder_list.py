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
        ## T.C = O(n)
        ## S.C = O(1)
        
        slow, fast = head, head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            
        curr = slow.next
        slow.next = None
        prev = None
        
        while curr:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
            
        first = head
        second = prev
        
        while second:
            tmp1 = first.next
            first.next = second
            second = second.next
            first.next.next = tmp1
            first = tmp1
        
        return None