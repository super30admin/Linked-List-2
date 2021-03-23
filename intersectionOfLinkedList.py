#TimeComplexity:O(N) 
#SpaceComplexity: O(M+N) to find the length of both lists
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA==None:
            return None
        p1=headA
        p2=headB
        lenA,lenB=0,0
        while(p1!=None):
            lenA+=1
            p1=p1.next
        while(p2!=None):
            lenB+=1
            p2=p2.next
        while(lenA>lenB):
            headA=headA.next
            lenA-=1
        while(lenA<lenB):
            headB=headB.next
            lenB-=1
        #print(lenA,lenB)
        while (not(headB==headA)):
            headB=headB.next
            headA=headA.next
        return headA
            
