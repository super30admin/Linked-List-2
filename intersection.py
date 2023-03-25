# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :no
# Your code here along with comments explaining your approach
# find the diff between lengths of two linked lists and move the one with higher length by diff no of steps
# now move both the heads by one and return the node where both heads become equal
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        tempA=headA
        lenA=0
        while headA:
            lenA+=1
            headA = headA.next
        tempB=headB
        lenB=0
        while headB:
            lenB+=1
            headB = headB.next
        print(lenA, lenB)
        if lenA == 0 or lenB ==0:
            return None
        if lenA > lenB:
            d = lenA - lenB
            while d > 0:
                tempA = tempA.next
                d-=1
        if lenB > lenA:
            d = lenB - lenA
            while d>0:
                tempB = tempB.next
                d-=1
        while tempA:
            if tempA==tempB:
                return tempA
            tempA = tempA.next
            tempB = tempB.next


        


                