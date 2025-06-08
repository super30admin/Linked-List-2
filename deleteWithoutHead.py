"""
Copy data from next node into current node.
Skip next node by making node.next = node.next.next.
Delete next node 
"""
"""
Time Complexity: O(1) 
Space Complexity: O(1)
"""

class Node:
    def __init__(self, data): 
        self.data = data
        self.next = None


def print_list(head):
    while head:
        print(head.data, end="  " if head.next else "\n")
        head = head.next


def delete_node_without_head(node):
    if node is None or node.next is None:
        print("Cannot delete this node (either None or last node)")
        return
    node.data = node.next.data
    node.next = node.next.next


if __name__ == "__main__":
    
    head = Node(1)
    head.next = Node(2)
    head.next.next = Node(3)
    head.next.next.next = Node(4)
    head.next.next.next.next = Node(5)

    node_to_delete = head.next.next  
    delete_node_without_head(node_to_delete)
    print_list(head) 

