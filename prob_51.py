#O(1) -  Space
#o(n) - Time

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        # edge case
        if not (head) or not (head.next):
            return

        first_half = self.find_mid(head)  # first half end point
        sec_half = self.reverse(first_half.next)  # second half of array
        first_half.next = None  # this will be last element
        first_half = head  # use the same variable to traverse the linked list
        temp = ListNode(0)
        while (first_half and sec_half):
            temp = first_half.next
            first_half.next = sec_half
            sec_half = sec_half.next
            first_half.next.next = temp
            first_half = temp

    def find_mid(self, head):
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def reverse(self, head):

        if not (head):
            return
        curr = head
        prev = None
        Next = None
        while curr:
            Next = curr.next
            curr.next = prev
            prev = curr
            curr = Next
        head = prev
        return head
