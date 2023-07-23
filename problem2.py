# Time Complexity: O(n) 
# Space Complexity: O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # find mid
        slow = head
        fast = head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # first and second halves 
        second = slow.next # second half 
        prev = None
        slow.next = None # for first half
        
        # reversing
        while second:
            temp = second.next
            second.next = prev
            prev = second 
            second = temp

        first = head
        second = prev
        while second:
            temp1, temp2 = first.next , second.next
            first.next = second
            second.next = temp1
            first, second = temp1, temp2
