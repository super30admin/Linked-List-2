# 143. Reorder List
# https://leetcode.com/problems/reorder-list/

# Time Complexity: O(n)
# Space Complexiety: O(1)

# Logic: We need to reverse the second half of the LL. 
# Then using both the heads, insert the nodes.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self,head):
        prev, cur = None, head
        
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        
        return prev
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # find mid of the LL
        slow, fast = head, head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse elements after mid
        head2 = self.reverse(slow.next)
        slow.next = None
            
        ptr = head
        # Insert elements
        while head2:
            temp = head.next
            head.next = head2
            head = temp
            temp = head2.next
            head2.next = head
            head2 = temp
        
        return ptr