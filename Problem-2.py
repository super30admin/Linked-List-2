class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if  head is None or head.next is None:
            return

        slow,fast =head,head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next

        head_first =head
        head_second = self.reverse(slow)

        while head_first and head_second:
            temp = head_first.next
            head_first.next=head_second
            head_first =temp

            temp = head_second.next
            head_second.next = head_first
            head_second = temp

        if head_first is not None:
            head_first.next=None


    def reverse(self,head):
        prev=None
        while(head):
            next = head.next
            head.next = prev
            prev=head
            head=next
        return prev
