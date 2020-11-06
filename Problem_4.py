"""
Time Complexity : O(n) where n is total nodes
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This is a two pass solution. If there is an intersection between those 2 lists, 
we could find it if both the lists had same length, ut that is not the case. So we will calculate length of boh
the lists, calculate the difference, lets say n. We will traverse the longer list by n nodes so that
the distance from both lists start pointer to intersection becomes same. Then we will start traversing 
both lists with same speed. The point where they meet is the intersection.

"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def getIntersectionNode(self, headA, headB):
        lenA = 0
        lenB = 0
        ptA = headA
        ptB = headB
        while ptA:
            lenA += 1
            ptA = ptA.next
        while ptB:
            lenB += 1
            ptB = ptB.next
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        while lenB < lenA:
            headA = headA.next
            lenA -= 1
        while headA != headB:
            headA = headA.next
            headB = headB.next
            if not headA or not headB:
                return None
        return headA
