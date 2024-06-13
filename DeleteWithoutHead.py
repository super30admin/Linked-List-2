# Time Complexity : O(1)
# Space Complexity : O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteNode(self, node: ListNode) -> None:
        if node is None or node.next is None:
            return  # We can't delete the node if it is null or if it is the last node
        node.val = node.next.val  # Copy the data from the next node to the current node
        node.next = node.next.next  # Delete the next node

# Helper function to print the linked list
def printList(head: ListNode) -> None:
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")

# Example 1
# List: 1 -> 2 -> 3 -> 4
# Deleting node with value 3 (without head pointer)
head1 = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
print("Original List 1: ", end="")
printList(head1)
Solution().deleteNode(head1.next.next)  # Node with value 3
print("Modified List 1: ", end="")
printList(head1)  # Expected Output: 1 -> 2 -> 4 -> None

# Example 2
# List: 10 -> 20 -> 30 -> 40 -> 50
# Deleting node with value 30 (without head pointer)
head2 = ListNode(10, ListNode(20, ListNode(30, ListNode(40, ListNode(50)))))
print("Original List 2: ", end="")
printList(head2)
Solution().deleteNode(head2.next.next)  # Node with value 30
print("Modified List 2: ", end="")
printList(head2)  # Expected Output: 10 -> 20 -> 40 -> 50 -> None

# Example 3
# List: 5 -> 10 -> 15
# Deleting node with value 10 (without head pointer)
head3 = ListNode(5, ListNode(10, ListNode(15)))
print("Original List 3: ", end="")
printList(head3)
Solution().deleteNode(head3.next)  # Node with value 10
print("Modified List 3: ", end="")
printList(head3)  # Expected Output: 5 -> 15 -> None