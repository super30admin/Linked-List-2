"""
Problem: 143. Reorder List
Leetcode: https://leetcode.com/problems/reorder-list/
Solution:
    - Find middle of the linked list
    - Reverse the linked list from the next element of middle
    - Merge two lists with one element from each
Time Complexity: O(n) because,
    - To find middle node, O(n)
    - To reverse the second part, O(n/2)
    - To merge two lists, O(n/2)
Space Complexity: O(1), only pointers are used
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Base case
        if not head or not head.next:
            return

        # find the middle of the linkedlist using slow and fast pointer
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # reverse the second part of the list
        # convert 1->2->3->4->5->6 into 1->2->3->4->None and 6->5->None
        # reverse the second half in place
        prev, curr = None, slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next

        # merge two sorted linked list
        # merge 1->2->3->4 and 6->5 into 1->6->2->5->3->4
        first, second = head, prev
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next
