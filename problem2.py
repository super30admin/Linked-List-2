# Time complexity is O(N) and space complexity is O(1)
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
        
        slow =head
        fast = head
        
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            
        second = slow.next     
        prev = None
        slow.next = None
        
        while second:
            temp = second.next
            second.next = prev
            prev= second
            second = temp
            
        first= head
        second = prev
        
        while second:
            temp1= first.next
            temp2= second.next
            first.next= second
            second.next = temp1
            first = temp1
            second = temp2