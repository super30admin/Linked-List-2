class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return 
        
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        prev = None
        
        while(slow):
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
            
        first, second = head, prev
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next
            
            
            #find the midle, reverse the second part, and the merge it. tc o(n) sc o(1)
