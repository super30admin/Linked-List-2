#
# Time Complexity = O(n) 
# Space Complexity = O(1)
#

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return None
        slow = head
        fast = head.next
        while(fast and fast.next):
            slow = slow.next
            fast = fast.next.next
        temp1 = head
        temp2 = slow.next
        slow.next = None
        prev = None
        while(temp2):
            nex = temp2.next
            temp2.next = prev
            prev = temp2
            temp2 = nex
        temp2 = prev
        while(temp1 and temp2):
            n1 = temp1.next
            n2 = temp2.next
            temp1.next = temp2
            temp2.next = n1
            temp1 = n1
            temp2 = n2
        return head
