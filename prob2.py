# Time Complexity :O(n)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return
        def reverse(head):
            prev = None
            curr = head
            fast = head.next
            while fast is not None:
                curr.next = prev
                prev = curr
                curr = fast
                fast = fast.next
            curr.next = prev
            return curr

        slow = fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        # reverse the second half of the linked list
        fast = reverse(slow.next)
        slow.next = None
        slow = head
        temp = ListNode()

        # merge ll
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp