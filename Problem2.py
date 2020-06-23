"""
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

--> reverse the given list at the center and then merge the resulting 2 lists

// Your code here along with comments explaining your approach
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        if not head or not head.next:
            return 
        
        slow = head
        fast = head
        while fast.next and fast.next.next: #finding mid of the linkedlist
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverse(slow.next) #reverse second half of the linkedlist
        slow.next = None
        slow = head
        
        while slow and fast: #join alternately 
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            
        return head
            
        
    def reverse(self, head): # function to reverse the linkedlist
        prev = None 
        cur = head
        fast = head.next
        
        while fast:
            cur.next = prev
            prev = cur
            cur = fast
            fast = fast.next
            
        cur.next = prev
        return cur