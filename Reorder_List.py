# Author: Naveen US
# Title: Reorder List

# Time complexity: O(n)
# Space complexity: O(1)
# Did the code run on leetcode: Yes

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head: return []
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        prev, curr = None, slow.next
        while curr:
            nextt = curr.next
            curr.next = prev
            prev = curr
            curr = nextt    
        slow.next = None
        
        head1, head2 = head, prev
        while head2:
            nextt = head1.next
            head1.next = head2
            head1 = head2
            head2 = nextt
