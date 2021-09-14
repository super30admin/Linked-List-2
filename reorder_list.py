# // Time Complexity : O(n) where n stand for length of the two lists 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

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
        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        cur = slow.next

        while cur:
            cur.next,prev,cur = prev,cur,cur.next
            
            # follow = cur.next
            # cur.next = prev
            # prev = cur
            # cur = follow

        slow.next = None
        
        pt1 = head
        pt2 = prev

        while pt2:
            t = pt1.next
            pt1.next = pt2
            pt2 = pt2.next
            pt1.next.next = t
            pt1 = t