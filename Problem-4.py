# T.C = O(n)  S.C = O(1)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        countA = 0 
        countB = 0
        tempA = headA
        tempB = headB

        while tempA != None:
            tempA = tempA.next
            countA+=1
            
        while tempB != None:
            tempB = tempB.next
            countB+=1

        while countA > countB:
            headA = headA.next
            countA-=1

        while countB > countA:
            headB = headB.next
            countB -=1

        while headA!=None or headB!=None: 

            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        return headA
