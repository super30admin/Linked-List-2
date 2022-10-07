# TC = O(n) --> mid point n/2 and reverseLL = n/2, thus O(n)
# SC = O(1)

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None: return

        # find length y using 2 pointers and find mid node
        slow = head
        fast = head

        # 1st condition from odd length LL AND seconf condition from even length LL
        while (fast.next is not None and fast.next.next is not None):
            slow = slow.next
            fast = fast.next.next

        # reverse the second half and break LL
        fast = self.reverseLL(slow.next)

        # split
        slow.next = None

        # reorder remerge
        slow = head
        temp = slow.next

        while fast is not None:
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            if temp is not None:
                temp = temp.next

    def reverseLL(self, head: Optional[ListNode]) -> None:
        if head is None or head.next is None: return head

        prev = None
        curr = head
        fast = head.next

        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev

        # head of reverseLL
        return curr
