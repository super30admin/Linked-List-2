'''https://leetcode.com/problems/reorder-list/'''



# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# Time Complexity : O(N) all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None: return
        
        slow = fast = head
        
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        second = slow.next
        slow.next = None
        
        p1 = head # streight list
        rev = self.reverse(second)  # reversed list
        nxt = rev.next
        
        while nxt is not None:
            rev.next = p1.next
            p1.next = rev
            p1 = p1.next.next
            rev = nxt
            nxt = nxt.next
        
        rev.next = p1.next
        p1.next = rev
        p1 = p1.next.next
        rev = nxt
        
        return
    
    def reverse(self, head):
        if head is None or head.next is None:
            return head
        
        prev = None
        curr = head
        nxt = head.next
        
        while nxt is not None:
            curr.next = prev
            prev = curr
            curr = nxt
            nxt = nxt.next
        
        curr.next = prev
        return curr
        
        
        
             
            
        
        
        
        