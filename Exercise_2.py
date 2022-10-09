# Time Complexity: O(n) 
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
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
        #find the middle element
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        #reverse the second half of the list
        prev = None
        curr = slow.next

        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            
        slow.next = None
        
        #prev is the starting of reversed list
        first = head
        second = prev
        temp = first.next
        
        while second:
            first.next = second
            second = second.next
            first.next.next = temp
            first = temp
            if temp:
                temp = temp.next
                
        return first