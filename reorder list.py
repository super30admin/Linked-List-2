class Solution:
    def reorderList(self, head: ListNode) -> None:
        if not head:
            return
        slow=fast=head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        prev=None
        curr=slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next 
        first=head
        second=prev
        while second.next:
            first.next,first=second,first.next
            second.next, second = first, second.next

#Time-Complexity: O(N)
#Space-complexity: O(1)