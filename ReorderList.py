# Time Complexity : O(n)
# Space Complexity : O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: ListNode) -> None:
        if not head or not head.next:
            return
        
        # Step 1: Find the middle of the linked list using the slow and fast pointers
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Step 2: Reverse the second half of the linked list
        second = self._reverseList(slow.next)
        slow.next = None  # Break the link between the two halves
        
        # Step 3: Merge the two halves
        first = head
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2

    def _reverseList(self, head: ListNode) -> ListNode:
        prev, curr = None, head
        while curr:
            next_temp = curr.next
            curr.next = prev
            prev = curr
            curr = next_temp
        return prev

# Helper function to print the linked list
def printList(head: ListNode) -> None:
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")

# Example 1
head1 = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
Solution().reorderList(head1)
printList(head1)  # Output: 1 -> 4 -> 2 -> 3 -> None

# Example 2
head2 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
Solution().reorderList(head2)
printList(head2)  # Output: 1 -> 5 -> 2 -> 4 -> 3 -> None

# Example 3
head3 = ListNode(1)
Solution().reorderList(head3)
printList(head3)  # Output: 1 -> None