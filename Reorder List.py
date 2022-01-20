# Time Complexity :
# TC: O(N)

# Space Complexity :
# SC: O(N)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# Traverse to mid of LL
# Reverse second half Of LL
# Break Link to divide LL in two
# Merge the LL using three pointers in 2 LL

 

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
        # TC: O(N)
        # SC: O(N)
        
        if (head.next is None or head.next.next is None):
            return
        
        fast = head
        slow = head
        temp = None
        
        # Traverse to mid of LL
        while (fast is not None and fast.next is not None):
            fast = fast.next.next
            slow = slow.next
    
        # Reverse second half Of LL
        fast = self.reverseLL(slow.next)
        
        # Break Link to divide LL in two
        slow.next = None
        
        # Intialize three pointers in 2 LL
        slow = head
        temp = slow.next
        # Fast is already pointing to head of second LL i.e head of reversed LL
        
        # Merge the LL
        while(fast is not None):
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
            temp = temp.next
        
    def reverseLL(self, head):
        prev = None
        curr = head
        nxt = curr.next
        
        while(curr is not None):
            curr.next = prev
            prev = curr
            curr = nxt
            if(nxt is not None):
                nxt = nxt.next
                
        return prev