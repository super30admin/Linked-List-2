
# tc: O(n)
# sc:O(1)


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return

        # 1. find the middle of the linked list
        slow = head
        fast = head

        while fast.next and fast.next.next is not None: #for even and add lost cant use only one condition because the program crashes if trying to access fast.next.next in the first place so before that fast.next is mandatory
            slow = slow.next
            fast = fast.next.next

        # 2. Reverse second half of LL
        fast = self.reverse(slow.next)  # calls the reverse method and second half is stored in slow.next
        slow.next = None  # broken the list in 2 parts
        slow = head

        # Merge the 2 lists together
        temp = None
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, head: ListNode) -> ListNode:  #function for step 2
        if head is None or head.next is None:
            return head
        prev = None
        curr = head
        fast = head.next

        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev  # For taking the remaining last element
        return curr



        