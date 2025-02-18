# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

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
        # find mid
        slow, fast = head, head

        if not head:
            return None
        
        if not head.next:
            return head

        slow = slow.next
        fast = fast.next.next

        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
        head2 = slow.next
        slow.next = None
        
        # reverse 2nd list
        print(head2)
        cur, prev = head2, None
        
        while cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
        
        head2 = prev

        # merge
        a = head
        b = head2

        while a and b:
            next_a = a.next
            a.next  = b
            next_b = b.next
            b.next = next_a
            a = next_a
            b = next_b