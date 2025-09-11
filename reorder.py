def reorderList(self, head: Optional[ListNode]) -> None:
    """
    Do not return anything, modify head in-place instead.
    """
    slow=head
    fast=head
    while fast and fast.next:
        slow=slow.next
        fast=fast.next.next
    reverseHead=self.reverselist(slow.next)
    slow.next=None

    slow=head
    fast=reverseHead
    while fast:
        temp=slow.next
        slow.next=fast
        fast=fast.next
        slow.next.next=temp
        slow=temp

def reverselist(self, head):
    prev=None
    curr=head
    while curr:
        temp=curr.next
        curr.next=prev
        prev=curr
        curr=temp
    return prev

