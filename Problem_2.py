
# 143. Reorder List

# Code:

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
        if not head:
            return
        
        p1 = head
        p2 = head
        
        # Finding the middle element
        while p2 and p2.next:
            p1 = p1.next
            p2 = p2.next.next
        
        
        dummy1 = head
        # Reversing the second half
        dummy2 = self.reverse(p1.next)
        p1.next = None
        
        # Connecting two linkedlists
        while dummy1 and dummy2:
            temp1 = dummy1.next
            dummy1.next = dummy2
            temp2 = dummy2.next
            dummy2.next = temp1
            dummy1 = temp1
            dummy2 = temp2
        
        return head
            
            
        
    # Function to reverse
    def reverse(self, head):
        curr = head
        prev = None
        nxt = None
        
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        return prev

# Time complexity: O(N) 
# Space complexity: O(1)
# Accepted on Leetcode: Yes.