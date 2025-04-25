from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # Approach:
    # 1. Find the middle of the list
    # 2. Reverse the second half
    # 3. Merge the two halves
    #
    # Time Complexity: O(n)
    # Space Complexity: O(1) – in-place modification

    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return

        # Step 1: Find the middle
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse second half
        prev, curr = None, slow.next
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        slow.next = None  # Split the list

        # Step 3: Merge two halves
        first, second = head, prev
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2


head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))

sol = Solution()
sol.reorderList(head)

# Print result
curr = head
while curr:
    print(curr.val, end=" -> ")
    curr = curr.next
