class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
#         find the midpoint
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
#        reverse the last half of list 
        def reverse(head):
            prev = None
            curr = head
            while curr:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
                
            return prev        
#         merge
        fast = reverse(slow.next)
        
        slow.next = None
        
        slow = head
        while fast:
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = curr
            slow = curr
        
        return head
