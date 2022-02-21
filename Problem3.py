class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    
    def append(self, data):
        new_node = Node(data)
        temp = self.head
        if self.head == None:
            self.head = new_node
            return
        while(temp):
            temp = temp.next
        temp.next = new_node
    
    def del_node(self, node):
        temp = node.next
        node.val = temp.val
        node.next = temp.next
        temp.next=None
    
