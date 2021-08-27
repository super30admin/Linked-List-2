class Solution:
    def reverseList(self, head):
        if head == None:
            return head
        prev, cur, fast = None, head, head.next
        while fast != None:
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
        cur.next = prev
        return cur

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Find middle
        reverse second part
        reorder
        TC - O(n)
        SC - O(1)
        """
        if not head:
            return None
        # Find middle
        slow, fast = head, head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

        # Reverse List
        fast = self.reverseList(slow.next)

        # Reorder
        slow.next = None
        slow = head
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
