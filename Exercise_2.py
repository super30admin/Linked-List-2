
    # 143. Reorder List
    # Time Complexity : O(N)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head
        
        while(fast.next and fast.next.next):
            slow = slow.next
            fast = fast.next.next

        
        prev = None
        curr = slow.next
        while curr!=None:
            Temp = curr.next
            curr.next = prev 
            prev = curr
            curr = Temp
            
        fast = prev
        
        slow.next = None
        slow = head
        
        while(fast):
            temp = slow.next
            slow.next = fast
            fast=fast.next
            slow.next.next=temp
            slow=temp
            
        
            
            
            
        