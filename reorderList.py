#Time Complexity: O(n)
#Space complexity: O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None or head.next.next==None:
            return 
        # finding mid
        slow=head
        fast=head
        # if list is odd or even
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
        mid=self.reverse(slow.next)
        slow.next=None
        slow=head
        #Reorder list
        while mid!=None:
            temp=slow.next
            slow.next=mid
            mid=mid.next
            slow.next.next=temp
            slow=temp
    def reverse(self, head:ListNode):
        prev=None
        curr=head
        while curr.next:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        curr.next=prev
        return curr
       