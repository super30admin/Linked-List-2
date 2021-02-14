# Time complexity: O(1)
# Space complexity: O(1)
# Worked on leetcode: yes
# To delete the node, we replace the value of the node with its next node, and connect its next pointer to
# next to next node.
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Linkedlist:
    def __init__(self):
        self.head = None

    # this pushes new node at the beginning of the list
    def push(self, new_data):
        new_node = Node(new_data) # first create a node
        new_node.next = self.head
        self.head = new_node


    def printlist(self):
        temp = self.head
        while (temp):
            print(temp.data, end = " ")
            temp = temp.next


    def delete_node(self, node):
        node.data = node.next.data
        node.next = node.next.next


llist = Linkedlist()
llist.push(5)
llist.push(4)
llist.push(8)
llist.push(2)
llist.push(1)
llist.printlist()

llist.delete_node(llist.head.next.next)
print("Deleted node")
llist.printlist()




