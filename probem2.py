# Time Complexity : O(n)
# Space Complexity : 0(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None  or head.next==None :
            return head
        prev = None
        curr = head
        fast = head.next
        while fast!= None:
            curr.next = prev
            prev = curr
            curr= fast
            fast = fast.next
        curr.next = prev
        return curr
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return 
        slow = head
        fast = head.next
        while fast!=None and fast.next!=None:
            slow= slow.next
            fast= fast.next.next
        
     
       
        fast = self.reverse(slow.next)
        

        slow.next = None
        slow = head
        dummy = slow.next
        while fast!= None:
            slow.next = fast
            fast= fast.next
            slow.next.next = dummy
            slow= dummy
            if slow == None:
                break
            dummy= dummy.next
        