# Time Complexity: O(n)
# Space Complexity: O(1)
# Ran On leetcode: Yes

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
        if not head:
            return None
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return
        
        
    def reverse(self, head):
        if not head:
            return head
        prev = None
        curr = head
        fast = head.next
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
        