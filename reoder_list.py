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
        if head == None or head.next == None:
            return 
        
        # Finding middle
        slow = head
        fast = slow.next
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
            
        # slow.next has 4 -> 5    
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        
        # Merge of LinkedList
        while fast != None:
            temp = slow.next
            slow.next = fast
            fast= fast.next
            slow.next.next = temp
            slow = temp
            
    #Reverse LinkedList
    def reverse(self, head):
        prev = None
        curr = head
        fast = curr.next

        while fast != None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next

        curr.next = prev
        return curr
