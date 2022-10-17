# Time complexity: O(n)
# Space complexity: O(1)

# Code sucessfully ran on Leetcode

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
        if head == None: return
        
        slow = head
        fast = head
        
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
            
        fast = self.reverse(slow.next)
        slow.next = None
        
        slow = head
        temp = slow.next
        
        while fast:
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            if temp:
                temp = temp.next

        return head
        
    def reverse(self, head: Optional[ListNode]):
        if head == None or head.next == None:   return head
        
        prev = None
        curr = head
        fast = head.next
        
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
            
        curr.next = prev
        
        return curr
            