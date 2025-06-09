# Time Complexity: O(n), where n is the number of nodes in the linked list
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: No

from collections import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        
        # OPTIMAL APPROACH

        if not head or not head.next:
            return  # nothing to do for 0 or 1 node

        # Step 1: Find the middle of the list
        def end_of_first_half(node):
            slow = node
            fast = node
            while fast.next and fast.next.next:
                slow = slow.next
                fast = fast.next.next
            return slow

        # Step 2: Reverse the second half of the list
        def reverse_list(node):
            prev = None
            curr = node
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev

        # Step 3: Merge the two halves
        first_half_end = end_of_first_half(head)
        second_half_start = reverse_list(first_half_end.next)
        first_half_end.next = None  # disconnect the two halves

        p1 = head
        p2 = second_half_start
        while p2:
            tmp1 = p1.next
            tmp2 = p2.next
            p1.next = p2
            p2.next = tmp1
            p1 = tmp1
            p2 = tmp2


# ------------------------------------------------------------------------------------------

        # BRUTE FORCE APPROACH
        # Time Complexity : O(n)
        # Space Complexity : O(n) to store nodes in array

        # if not head:
        #     return

        # nodes = []
        # curr = head
        # while curr:
        #     nodes.append(curr)
        #     curr = curr.next

        # l = 0
        # r = len(nodes) - 1

        # while l < r:
        #     nodes[l].next = nodes[r]
        #     l += 1
        #     if l == r:
        #         break
        #     nodes[r].next = nodes[l]
        #     r -= 1

        # nodes[l].next = None
