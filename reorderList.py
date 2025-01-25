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
        # T: O(n), S: O(1)
        if not head or not head.next:
            return
        # Split the LL
        s, f = head, head
        while f.next and f.next.next:
            s = s.next
            f = f.next.next
        ll2 = s.next
        s.next = None
        # Reverse the 2nd half
        f = self.reverseList(ll2)
        s.next = None
        # Merge alternatively
        s = head
        while f:
            t = s.next
            s.next = f
            f = f.next
            s.next.next = t
            s = t

    def reverseList(self, head):
        if not head or not head.next:
            return head
        p, c = None, head
        while c:
            t = c.next
            c.next = p
            p = c
            c = t
        return p
