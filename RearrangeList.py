# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return
        
        # first find middle
        slow = head
        fast = head
        while(fast.next != None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next
            
        # slow is now at mid reverse from middle to end
        fast = self.reversedHalf(slow.next)
        
        # slow is now at mid so need to point the mid to none
        slow.next = None
        
        # merge the two lists 
        slow = head
        temp = None 
        while(fast != None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
    def reversedHalf(self, head):
        prev = None
        curr = head
        fast = head.next
        
        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
            
        curr.next = prev
        return curr
            
            
        