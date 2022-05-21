'''
time complexity: O(n)
space complexity: O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        countA = 0
        countB = 0
        tempA = headA
        tempB = headB
        while(tempA!=None):
            countA+=1
            tempA=tempA.next
        while(tempB!=None):
            countB+=1
            tempB=tempB.next
            
        if(countA>countB):
            while(countA!=countB):
                headA=headA.next
                countA-=1
        
        if(countA<countB):
            while(countA!=countB):
                headB=headB.next
                countB-=1
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
            
            
        return headA
        