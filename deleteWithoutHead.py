# The easy way  to delete the node is copy the data into temp node then delete the node in regular way
# Time Complexity: O(1)
#Space Compelxity: O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def delete(self,node):
        if node is None or node.next is None:
            return
        temp = node.next
        node.data = node.next.val
        node.next = node.next.next

    def printList(self,head):
        if head is None:
            return
        temp = head
        while temp is not None:
            print(temp.val)
            temp = temp.next

n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n1.next = n2
n2.next = n3
n3.next = n4
s = ListNode()
np = n2
s.delete(np)
s.printList(n1)
