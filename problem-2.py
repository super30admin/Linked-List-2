class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        if not head:
            return
        # ensure the first part has the same or one more node
        fast, slow = head.next, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        # reverse the second half
        p = slow.next
        slow.next = None
        node = None
        while p:
            nxt = p.next
            p.next = node
            node = p
            p = nxt
        # combine head part and node part
        p = head
        while node:
            tmp = node.next
            node.next = p.next
            p.next = node
            p = p.next.next #p = node.next
            node = tmp
