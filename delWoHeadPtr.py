# T: O(1), S: O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def deleteNode(node: ListNode):
    # Copy the value of the next node into the current node
    node.val = node.next.val
    # Bypass the next node
    node.next = node.next.next


# Helper function to print the linked list
def printList(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")


# Create a linked list: 4 -> 5 -> 1 -> 9
head = ListNode(4, ListNode(5, ListNode(1, ListNode(9))))

# Node to be deleted (e.g., the node with value 5)
node_to_delete = head.next  # Node with value 5

print("Before deletion:")
printList(head)

deleteNode(node_to_delete)

print("After deletion:")
printList(head)
