#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : yes

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
            prev=ListNode(0,head)
            slow=fast=head
            total=0
            while fast and fast.next:
                fast=fast.next.next
                total+=2
                slow=slow.next
                prev=prev.next
            while slow:
                slow.next,prev,slow=prev,slow,slow.next
            dummy=h1=ListNode(0)
            l,r=head,prev
            for _ in range(total//2):
                h1.next,l=l,l.next
                h1=h1.next
                h1.next,r=r,r.next
                h1=h1.next
            h1.next=l
            h1.next.next=None
            return dummy.next