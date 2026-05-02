# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head):
        if not head or not head.next:
            return head
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        revHead = self.reverseLL(slow.next)
        slow.next = None
        slow = head
        while revHead:
            nextslow = slow.next
            nextrevHead = revHead.next
            slow.next = revHead
            revHead.next = nextslow
            slow = nextslow
            revHead = nextrevHead
        return head

    def reverseLL(self, head):
        if not head or not head.next:
            return head
        newHead = self.reverseLL(head.next)
        head.next.next = head
        head.next = None
        return newHead
