#Reorder list
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# First, we find the middle of the linked list using the slow and fast pointer technique.
# Then, we reverse the second half of the linked list.
# Finally, we merge the two halves together by alternating nodes from each half.
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow,fast = head,head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev = None
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
        slow = head
        while prev.next:
            tmp = slow.next
            slow.next = prev
            prev = prev.next
            slow.next.next = tmp
            slow = tmp
        return head


        