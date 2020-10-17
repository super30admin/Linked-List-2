# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
"""
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:

        # Check for null
        if headA is None or headB is None:
            return None
        
        # Concatenate A and B
        p1 = headA
        while p1.next:
            p1 = p1.next
        last = p1
        last.next = headB

        # Find the start of the loop
        return self.detectCycle(headA, last)
    
    def detectCycle(self, head, last) -> ListNode:
        
        if head is None:
            return head
                
        curr = slow = fast = head
        temp = None
        while(fast and fast.next):
            fast = fast.next.next
            slow = slow.next
            
            if(slow == fast):
                temp = slow
                break
        
        # Set last node.next to null to return to original
        # conditions
        if temp is None:
            last.next = None
            return None
        
        while(curr != temp):
            temp = temp.next
            curr = curr.next
        last.next = None    

        return curr