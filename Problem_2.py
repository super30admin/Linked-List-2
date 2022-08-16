"""
Time Complexity : O(n)
Space Complexity :O(1)
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem2 (https://leetcode.com/problems/reorder-list/)
"""
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
        if head == None: return None
        
        # finding the middle linked list
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # reversing the second part (after the middle) list
        prev, curr = None, slow    
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        # merging two  list
        first, second = head, prev
        while second.next:
            temp = first.next
            first.next = second
            first = temp
            
            temp = second.next
            second.next = first
            second = temp
        
    
    
        
        