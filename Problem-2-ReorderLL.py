# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def recurr(self, head2):

        prev = None
        curr = head2
        fast = head2.next

        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev

        return curr

    def reorderList(self, head) :
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return head

        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        head2 = slow.next
        slow.next = None

        head2 = self.recurr(head2)

        head1 = head

        while head1 != None and head2 != None:
            temp1 = head1.next
            temp2 = head2.next
            head1.next = head2
            head2.next = temp1

            head1 = temp1
            head2 = temp2

        return head2



