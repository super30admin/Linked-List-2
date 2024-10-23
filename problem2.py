# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Approach:
# The `reorderList` function reorders the linked list in-place, such that the nodes follow the pattern:
# L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
# 1. Find the middle of the list using the slow and fast pointer approach.
# 2. Split the list into two halves, and reverse the second half of the list.
# 3. Merge the two halves, alternating nodes from the first half and the reversed second half.
# 
# Time Complexity:
# - O(n), where n is the number of nodes in the list. Finding the middle takes O(n), reversing the second 
#   half takes O(n/2), and merging both halves also takes O(n).
# 
# Space Complexity:
# - O(1), as we only use a few extra pointers and modify the list in place.

class Solution(object):
    def reorderList(self, head):
        # Step 1: Find the middle of the list
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the second half of the list
        second = slow.next
        slow.next = None
        prev = None
        while second:
            tmp = second.next
            second.next = prev
            prev = second
            second = tmp

        # Step 3: Merge the two halves
        first, second = head, prev
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first = tmp1
            second = tmp2
