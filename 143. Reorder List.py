"""
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        
        This problem is a combination of these three easy problems:

Middle of the Linked List.

Reverse Linked List.

Merge Two Sorted Lists.
        """
        # Runtime Complexity: O(N)
        # Space Complexity: O(1)
        if not head:
            return 
        def split(head):
            slow = head
            fast = head
            while fast and fast.next:
                slow = slow.next
                fast = fast.next.next
            middle = slow.next
            slow.next = None
            return head, middle
        
        def reverse(head):
            node = None
            while head:
                temp = head.next
                head.next = node
                node = head
                head = temp
            return node
        
        def merge(first, second):
            head = first
            tail = first
            first = first.next
            while second:
                tail.next = second
                tail = tail.next
                second = second.next
                first, second = second, first
            return head
        
        first_half, second_half = split(head)
        second_half = reverse(second_half)
        head = merge(first_half, second_half)