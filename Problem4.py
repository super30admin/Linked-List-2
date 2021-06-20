# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


#iterating through the linked list count the elements
#check the difference and start from that to find where they meet
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        nodeA = headA
        countA = 0
        while nodeA != None:
            countA += 1
            nodeA = nodeA.next
        nodeB = headB
        countB = 0
        while nodeB != None:
            countB += 1
            nodeB = nodeB.next
        a,b = None,None
        if countA > countB:
            a,b = headA,headB
        else:
            a,b = headB,headA
        diff = abs(countA-countB)
        
        while diff != 0:
            diff -= 1
            a = a.next
        while a != b:
            a = a.next
            b = b.next
        
        return a