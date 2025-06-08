# Time Complexity: O(n) - Find middle O(n) + Reverse O(n) + Merge O(n)
# Space Complexity: O(1)
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
        slow: ListNode = head
        fast: ListNode = head
        # find Middle 
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        # Merge
        while fast != None:
            temp: ListNode = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp


    def reverse(self, curr: Optional[ListNode]):
        prev: ListNode = None
        while curr != None:
            temp: ListNode = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev