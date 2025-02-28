#Time Complexity : O(N) --> O(N) + O(N) + O(N) for finding the midpoint, reversing the second half and merging it back
#Space Complexity : O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #Assign slow and fast pointer
        slow = head
        fast = head
        #fast!=None for even case and fast!=fast.next for odd to find the mid
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast=fast.next.next
        #Reverse the second half of list
        fast = self.reverse(slow.next)
        #slow is the mid point, the connection to second half must be revoked
        slow.next = None
        slow = head
        #Assigning the links as per re-order arrangement
        while(fast!=None):
            temp = slow.next
            slow.next = fast 
            fast = fast.next
            slow.next.next = temp
            slow = temp
    #Function to reverse the second half of list 
    def reverse(self,head):
        prev = None
        curr = head
        while(curr!=None):
            temp = curr.next
            curr.next = prev
            prev= curr
            curr = temp
        return prev