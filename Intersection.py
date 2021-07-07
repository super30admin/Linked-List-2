// Time Complexity :o(m+n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        countA=0
        countB=0
        nodeA=headA
        nodeB=headB
        while(nodeA!=None):
            countA+=1
            nodeA=nodeA.next
        while(nodeB!=None):
            countB+=1
            nodeB=nodeB.next
        while(countA>countB):
            countA-=1
            headA=headA.next
        while(countB>countA):
            countB-=1
            headB=headB.next
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        return headA
        
