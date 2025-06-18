"""
Deletes the node by copying the data from the next node
and bypassing it.

Time: O(1)
Space: O(1)
"""

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class solution:
    def deleteNode(self, node):
        node.val = node.next.val
        node.next = node.next.next

def printList(head):
    while head:
        print(head.val, end=" -> " if head.next else "")
        head = head.next
    print()

def main():
    # Example: 10 -> 20 -> 4 -> 30
    head = ListNode(10)
    head.next = ListNode(20)
    head.next.next = ListNode(4)
    head.next.next.next = ListNode(30)

    print("Before deletion:")
    printList(head)

    # Delete node with value 20 (we pass reference to the node)
    node_to_delete = head.next
    sol = solution()
    sol.deleteNode(node_to_delete)

    print("After deletion:")
    printList(head)

if __name__ == "__main__":
    main()