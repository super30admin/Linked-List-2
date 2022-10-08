#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        # Reverse the second half of the list
        prev, cur = None, slow.next
        while cur:
            after = cur.next
            cur.next = prev
            prev = cur
            cur = after
        slow.next = None
 
        # Merge first and second half of the list
        first_part, second_part = head, prev
        while second_part:
            temp_1, temp_2 = first_part.next, second_part.next
            first_part.next = second_part
            second_part.next = temp_1
            first_part = temp_1
            second_part = temp_2