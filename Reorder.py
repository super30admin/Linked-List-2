#Time Complexity : O(n)

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next
        
        previous = None
        fast = slow.next
        while(fast):
            temp = fast.next
            fast.next = previous
            previous = fast
            fast = temp
        fast = previous
        slow.next = None
        slow = head
        while(fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return head
