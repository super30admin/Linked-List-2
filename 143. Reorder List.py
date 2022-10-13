# find mid(slow-fast pointer) --> reverse from slow.next --> merge
# TC - O(n) & SC - O(1)
class Solution:
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return

        #mid
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        #reverse second half
        second = slow.next
        prev = None 
        next = None
        while second != None:
            next = second.next
            second.next = prev
            prev = second
            second = next          
            
        fast = prev
        slow.next = None
        slow = head
            
        #merge
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
