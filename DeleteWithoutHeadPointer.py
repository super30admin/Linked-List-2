class ListNode:
    def __init__(self,val=0,next=None):
        self.val=val
        self.next=next

class Solution:
    def deleteNode(self,node):
        if node is None or node.next is None:
            return
        node.val=node.next.val
        node.next=node.next.next

def printList(head):
    while head:
        print(head.val,end="->"if head.next else "")
        head=head.next
    print()

head=ListNode(10)
head.next=ListNode(20)
head.next.next=ListNode(4)
head.next.next.next=ListNode(30)

print("Before:")
printList(head)

node_to_delete=head.next
Solution().deleteNode(node_to_delete)


print("After:")
printList(head)
