# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # Approach:
    # Since we do not have access to the head or the previous node,
    # we copy the value of the next node into the current node,
    # and then skip the next node.
    #
    # Time Complexity: O(1) – constant time
    # Space Complexity: O(1) – no extra space used
    def deleteNode(self, node: ListNode) -> None:
        node.val = node.next.val  # Copy value from next node
        node.next = node.next.next  # Skip the next node


head = ListNode(10, ListNode(20, ListNode(4, ListNode(30))))
del_node = head.next  # Node with value 20

# Print before
curr = head
while curr:
    print(curr.val, end=" ")
    curr = curr.next
print()

Solution().deleteNode(del_node)

# Print after
curr = head
while curr:
    print(curr.val, end=" ")
    curr = curr.next
