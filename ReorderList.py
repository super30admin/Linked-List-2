'''
    Time Complexity:
        O(n)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Break the list into two halves.
        Reverse the second half.
        Merge the two halves.
'''
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return

        rev_head = self.get_second_half(head)
        rev_head = self.reverse(rev_head)
        self.merge(head, rev_head)

    def get_second_half(self, head):
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        second_head = slow.next
        slow.next = None
        return second_head

    def reverse(self, head):
        prev = None
        curr = head

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        return prev

    def merge(self, head1, head2):
        while head1 and head2:
            nxt1 = head1.next
            nxt2 = head2.next

            head1.next = head2
            head2.next = nxt1

            head1 = nxt1
            head2 = nxt2
