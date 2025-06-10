class ListNode:
    def __init__(self,val=0,next=None):
        self.val=val
        self.next=next

class Solution:
    def reorderList(self,head):
        if not head or not head.next:
            return
        
        slow=fast=head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next

            prev=None
            curr=slow.next
            slow.next=None
            while curr:
                tmp=curr.next
                curr.next=prev
                prev=curr
                curr=tmp
            
            first=head
            second=prev
            while second:
                tmp1=first.next
                tmp2=second.next

                first.next=second
                if tmp1 is None:
                    break
                second.next=tmp1

                first=tmp1
                second=tmp2

def buildLinkedList(values):
    if not values:
        return None
    head=ListNode(values[0])
    current=head
    for val in values[1:]:
        current.next=ListNode(val)
        current=current.next
    return head

def printLinkedList(head):
    result=[]
    while head:
        result.append(head.val)
        head=head.next
    print(result)

sol=Solution()
head=buildLinkedList([1,2,3,4,5])
sol.reorderList(head)
printLinkedList(head)