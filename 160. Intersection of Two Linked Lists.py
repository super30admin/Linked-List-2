#Time Complexity:O(n)
#Space Complexity:O(1)

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
        countA=0
        countB=0
        currA=headA
        currB=headB
        while currA:
            currA=currA.next
            countA+=1
        while currB:
            currB=currB.next
            countB+=1
        if countA>countB:
            while(countA!=countB):
                countA-=1
                headA=headA.next
        if countB>countA:
            while(countB!=countA):
                countB-=1
                headB=headB.next
        while headA and headB:
            if headA==headB:
                return headA
                break
            headA=headA.next
            headB=headB.next
        return None

