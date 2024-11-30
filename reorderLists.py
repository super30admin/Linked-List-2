
"""
Time complexity: O(N)
Space complexity: O(1) (We are not using any extra auxillary memory)
Compiled on leetcode: Yes
Difficulties faced: None
"""
class Solution:
    def reverse(self, head):
        prev = None
        current = head
        while current is not None:
            nxt = current.next
            current.next = prev
            prev = current
            current = nxt
        return prev
    
    def reorderList(self, head: ListNode) -> None:
        
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None:
            return
        slow = head
        fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        temp = self.reverse(slow.next)
        slow.next = None
        slow = temp
        fast = head
        
        while fast is not None and slow is not None:
            temp = fast.next
            fast.next = slow
            slow = slow.next
            fast.next.next = temp
            fast = temp
            