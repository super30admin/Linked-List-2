# Time complexity: O(n)
# Space complexity: O(1)
# Approach: find the length of two separate lists.
# traverse the largest list until length equals, from there find the intersecting node
# if no intersection, the node will go to None and return the node




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        len1 = 0
        curr = headA
        while curr:
            curr = curr.next
            len1 = len1 + 1
        len2 = 0
        curr = headB
        while curr:
            curr = curr.next
            len2 = len2 + 1
        curr1 = headA
        curr2 = headB
        
        while len1 > len2:
            curr1 = curr1.next
            len1 = len1 - 1
        while len2 > len1:
            curr2 = curr2.next
            len2  = len2 - 1
            
        while curr1 != curr2:
            curr1 = curr1.next
            curr2 = curr2.next
        return curr1
                
        
        
            
        