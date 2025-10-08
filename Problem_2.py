# // Time Complexity : O(n)
# // Space Complexity : O(1)


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return
        
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        curr = slow.next
        while curr:
            next_temp = curr.next
            curr.next = prev
            prev = curr
            curr = next_temp
        

        slow.next = None
        first, second = head, prev
        
        while second:
            next_first = first.next
            next_second = second.next
            
            first.next = second
            second.next = next_first
            
            first = next_first
            second = next_second