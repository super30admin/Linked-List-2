"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach

Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
"""

# Approach - 1
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        """
        Using hash_set to store the nodes in headA. checking the nodes of headB in hash_set.
        Time Complexity: O(m + n)
        Space Complixt : O(m)
        """
        
        if headA==None or headB==None: return None
        
        visited_node = set()
        
        hA, hB = headA, headB
        while hA:
            visited_node.add(hA)
            hA = hA.next
            
        while hB:
            if hB in visited_node:
                return  hB
            else:
                hB = hB.next
                
        return None

# Approach - 2
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def len_linkedlist(self, head):
        if head == None: return 0
        
        curr = head
        _size = 0
        
        while curr:
            _size += 1
            curr = curr.next
        
        return _size
    
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        """
        Using two pointer to iterate overe two list. 
        Time Complexity: O(m + n)
        Space Complixt : O(1)
        """
        
        if headA==None or headB==None: return None
        
        len_hA = self.len_linkedlist(headA)
        len_hB = self.len_linkedlist(headB)
        
        hA = headA
        hB = headB
        # Find the same starting point for both the list
        while abs(len_hA - len_hB) != 0:
            if len_hA > len_hB:
                len_hA -= 1
                hA = hA.next
            else:
                len_hB -= 1
                hB = hB.next
        # moving both the pointers in the respective lists simultaneously
        while hA and hB and hA != hB:
            hA = hA.next
            hB = hB.next
            
        return hA
            
                
        
       