# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        slow = fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        prev = None
        curr = slow
        while curr != None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        second = prev 
        first = head
        while second.next != None:
            temp = first.next
            first.next = second
            first = temp
            
            temp2 = second.next
            second.next = first
            second = temp2
            
            