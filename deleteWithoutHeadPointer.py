# Time Complexity : O(1)
# Space Complexity : O(1)

# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
1. Copy next pointer data and next value in current pointer
"""

import unittest


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def __repr__(self):
        return self.data

class LinkedList:
    def __init__(self, nodes=None):
        self.head = None
        if nodes is not None:
            node = Node(data=nodes.pop(0))
            self.head = node
            for elem in nodes:
                node.next = Node(data=elem)
                node = node.next

    def __iter__(self):
        node = self.head
        while node is not None:
            yield node
            node = node.next

    def add_first(self, node):
        node.next = self.head
        self.head = node
    
    def add_last(self, node):
        if not self.head:
            self.head = node
            return
        for current_node in self:
            pass
        current_node.next = node

    def __repr__(self):
        node = self.head
        nodes = []
        while node is not None:
            nodes.append(node.data)
            node = node.next
        nodes.append("None")
        return " -> ".join(nodes)

    # delete node
    def deleteNode(self, node):
        if node.next == None :
            node = None
        else:
            node.data = node.next.data
            node.next = node.next.next



if __name__ == "__main__":
    llist = LinkedList()
    nodeA = Node("A")
    nodeB = Node("B")
    nodeC = Node("C")
    llist.add_first(nodeA)
    llist.add_last(nodeB)
    llist.add_last(nodeC)
    llist.deleteNode(nodeA)
    print(llist)

