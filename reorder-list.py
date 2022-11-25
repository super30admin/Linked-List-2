#TC: O(n)
#SC: O(1)
class Solution:
    def reverse(self,head):
        if not head or not head.next: return head
        p,c,n=None,head,head.next
        while c:
            c.next=p
            p=c; c=n
            if n: n=n.next
        return p

    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next: return head
        m,f=head,head
        while f and f.next: m=m.next; f=f.next.next
        new_head=self.reverse(m)
        itr1,itr2=head,new_head
        while itr1 and itr2 and itr1!=itr2:
            itr1_next,itr2_next=itr1.next,itr2.next
            if itr1.next==itr2:
                break
            itr1.next=itr2
            itr2.next=itr1_next
            itr1=itr1_next;itr2=itr2_next

        return head 