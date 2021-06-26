"""
Time Complexity : O(n). 
Space Complexity : O(1).
    
"""

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
        if not head or not head.next:
            return head 
        
        #Move till half of the linked list 
        slow = fast = head 
        
        while fast.next and fast.next.next:
            slow = slow.next 
            fast = fast.next.next 
        
        #Reverse the latter half of the linked list 
        def reverse(node):
            if not node or not node.next:
                return node
            
            last = reverse(node.next)
            node.next.next = node 
            node.next = None 
            return last 
        
        fast = slow.next
        fast = reverse(fast)
        
        slow.next = None 
        slow = head 
        
        
        #Merge alternatively 
        while fast:
            temp = slow.next 
            slow.next = fast 
            
            fast = fast.next 
            slow.next.next = temp 
            
            slow = temp 
        
        return head 
            
        
        
        