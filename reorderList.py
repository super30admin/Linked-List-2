# TC: O(n)
# SC: O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow=fast=head
        while fast.next and fast.next.next:
            fast=fast.next.next
            slow=slow.next
        
        curr=slow.next
        prev=None
        slow.next=None
        while curr:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp


        p2=prev
        p1=head

        while p1 and p2:
            temp1=p1.next
            temp2=p2.next

            p1.next=p2
            p2.next=temp1

            p1=temp1
            p2=temp2  