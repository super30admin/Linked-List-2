# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: The code reorders a linked list in the pattern L0 → Ln → L1 → Ln-1 → L2 → Ln-2 …. It first finds the middle of the list with slow/fast pointers, then reverses the second half. Finally, it merges nodes alternately from the first half and the reversed second half until the list is fully reordered


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head

        while(fast.next is not None and fast.next.next is not None):
            slow = slow.next
            fast = fast.next.next
        
        reversedHead = self.reverse(slow.next)
        slow.next = None

        fast = reversedHead
        slow = head
        
        while(fast is not None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp 

    def reverse(self, head: Optional[ListNode]):
        curr = head
        prev = None

        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        return prev