# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity is O(n)
# Space Complexity is O(1)
# Find Middle
# Reverse second half
# Merge first half with second half
class Solution(object):
    def reverse(self,head):
        if head is None:
            return head
        prev = None
        curr = head
        nextt = head.next
        while(nextt):
            
            temp = nextt.next
            nextt.next = curr
            curr.next = prev
            
            prev = curr
            curr = nextt
            nextt = temp
        
        return curr
    
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        
        slow = head
        fast = head
        while(fast and fast.next):
            fast = fast.next.next
            slow = slow.next
        
        # Reverse the second half
        second = self.reverse(slow)
        slow.next = None
        
        # Merge the two linked lists
        l1 = head
        l2 = second
        
        while(l2.next):
            l1.next,l1 = l2,l1.next
            l2.next,l2 = l1,l2.next
        