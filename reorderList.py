"""
//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if head is None:
            return
        slow = head 
        fast = head
        while(fast!=None and fast.next!=None):
            slow=slow.next
            fast = fast.next.next
            
        fast = self.reverseList(slow.next)
        slow.next = None
        slow = head
        
        while(fast!=None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
    def reverseList(self,head):
        if head is None:
            return None
        curr = head
        prev = None
        fast = head.next
        while(fast!=None):
            curr.next = prev
            prev = curr
            curr= fast
            fast = fast.next
        curr.next = prev
        return curr
    
        