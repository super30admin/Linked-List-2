# Time complexity -> O(n)
# Space complexity -> O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return None
        
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        secondHalf = self.reverseList(slow.next)  
        slow.next = None
        firstHalf = head
        
        while secondHalf:
            temp = firstHalf.next
            firstHalf.next = secondHalf
            secondHalf = secondHalf.next
            firstHalf.next.next = temp
            firstHalf = temp            

    def reverseList(self,head):
        prev = None
        curr = head
        
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            
        return prev