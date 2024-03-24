# TC = O(n)
# SC = O(1)
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
        slow = head
        fast = head
        # find mid
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        # slow is mid
        print(slow.val)
        fast = self.reverse(slow.next)
        slow.next = None

        # merge two linkedList
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, curr):
        prev = None
        fast = None
        while curr != None:
            fast = curr.next
            curr.next = prev
            prev = curr
            curr = fast
        return prev
