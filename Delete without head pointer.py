class ListNode:
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next
    
class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def isEmpty(self):
          return True if self.head == None else False

    def append(self, data):
        if self.head == None:
            self.head = ListNode(data, None)
        else:
            i = self.head
            while i.next != None:
                i = i.next
            newnode = ListNode(data, None)
            i.next = newnode
        return

    def find(self, key):
        i = self.head
        while  i != None and i.data != key:
            i = i.next
        return i

    def show(self):
        if self.isEmpty():
            return
        else:
            i = self.head
            out = '[TOP] '
            while i != None:
                out = out + str(i.data) + ' -> '
                i = i.next
            return out

#THIS IS THE SOLUTION; rest are all helper classes/functions
def deleteNode(node):                   #should not be a tail node
    #Time Complexity: O(1)
    #Space Complexity: O(1)
    
    node.data = node.next.data
    node.next = node.next.next

linkedList = SinglyLinkedList()
linkedList.append(1)
linkedList.append(2)
linkedList.append(3)
linkedList.append(4)
linkedList.append(5)

print("LinkedList before deletion:", linkedList.show())
deleteNode(linkedList.find(3))      #deleting node w/ value 3
print("LinkedList after deletion:", linkedList.show())