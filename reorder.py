# The code defines a reorderList method to reorder a linked list such that the nodes are rearranged in the order:
# first node -> last node -> second node -> second last node -> and so on.
# The method modifies the linked list in place.

# Step 1: Find the Middle of the List
#   - Use two pointers, 'slow' and 'fast':
#       - 'slow' moves one step at a time, while 'fast' moves two steps at a time.
#       - When 'fast' reaches the end of the list, 'slow' will point to the middle node.
#   - This splits the list into two halves.

# Step 2: Reverse the Second Half of the List
#   - Start from the node after 'slow' and reverse the second half of the list:
#       - Use a 'prev' pointer initialized to None to reverse the links.
#       - For each node in the second half, reverse its next pointer to point to the previous node.
#       - Continue until all nodes in the second half are reversed.
#       - 'prev' will now point to the head of the reversed second half.

# Step 3: Merge the Two Halves
#   - Use two pointers, 'first' (starting from the head of the first half) and 'second' (starting from the head of the reversed second half).
#   - Merge the nodes alternately:
#       - Connect 'first.next' to 'second', and 'second.next' to the next node in the first half (tmp1).
#       - Move both 'first' and 'second' forward to their respective next nodes (tmp1 and tmp2).
#   - Continue this process until the second half is fully merged into the first.

# Final Result:
#   - The linked list is reordered in place according to the specified pattern.

# TC: O(n) - The list is traversed multiple times: once to find the middle, once to reverse the second half, and once to merge the two halves.
# SC: O(1) - The space complexity is constant, as the reordering is performed in place without additional data structures.


from typing import Optional


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        second = slow.next
        prev = slow.next = None
        while second:
            tmp = second.next
            second.next = prev
            prev = second
            second = tmp

        first, second = head, prev
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2