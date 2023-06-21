'''
Problem: Reorder a list
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        find the middle of the list
        reverse the second half of the list
        then merge the first half and second half
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self,head):
        prev = None
        curr = head
        fast = head.next

        while(fast):
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        
        curr.next = prev
        return curr

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return 
        #middle
        slow = head
        fast = head
        while(fast.next and fast.next.next):
            slow = slow.next
            fast=fast.next.next
        
        #reverse
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head

        #merge
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        
            
        