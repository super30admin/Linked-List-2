'''
Problem:  Intersection of Two Linked Lists
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        calculated lengths of both list
        started traversing at equal length
        compared each node, if equal then intersection found
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        curA = headA
        curB = headB
        lenA = 0
        lenB = 0

        while curA:
            lenA+=1
            curA=curA.next
        
        while curB:
            lenB+=1
            curB = curB.next
        
        curA = headA
        curB = headB

        if lenA>lenB:
            while lenA!=lenB:
                curA=curA.next
                lenA-=1
        else:
            while lenA!=lenB:
                curB = curB.next
                lenB-=1
            
        while curA!=curB:
            curA=curA.next
            curB=curB.next
            
        if curA==curB:
            return curA
            
        return None