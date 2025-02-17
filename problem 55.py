# https://leetcode.com/problems/intersection-of-two-linked-lists/

# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1 = 0
        l2 = 0

        pt1 = headA
        while(pt1 is not None):
            pt1 = pt1.next
            l1+=1
        
        pt2 = headB
        while(pt2 is not None):
            pt2 = pt2.next
            l2+=1
        
        pt1 = headA
        pt2 = headB
        diff = abs(l1-l2)
        if (l1>l2):
            while diff:
                pt1 = pt1.next
                diff-=1
        else:
            while diff:
                pt2 = pt2.next
                diff-=1

        while(pt1!=pt2):
            pt1 = pt1.next
            pt2 = pt2.next
    
        return pt1


        
        