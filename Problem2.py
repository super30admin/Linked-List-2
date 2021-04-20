## Problem2 (https://leetcode.com/problems/reorder-list/)

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
        if head ==None:
            return
        slow = head 
        fast = head
        temp = ListNode()
        while fast.next!=None and fast.next.next!=None:
            slow = slow.next 
            fast = fast.next.next
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        while fast!=None:
            temp = slow.next
            slow.next = fast
            fast = fast.next 
            slow.next.next = temp 
            slow = temp
        
    def reverse(self, head):
        prev = None
        curr = head
        if head==None:
            return head
        fast = head.next
        while fast!=None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr
    #Time complexity: O(n)
    #Space Complexity: O(1)
    #Approach: find middle element and break them into two lists, reverse the list after ther mid point and then take up one element by one from both the lists and merge. 
