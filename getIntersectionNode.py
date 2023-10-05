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
        # Time Complexity: O(m+n)
        # Space Complexity: O(n)

        # hashSet=set()
        # while headA:
        #     hashSet.add(headA)
        #     headA=headA.next
        # while headB:
        #     if headB in hashSet:
        #         return headB
        #     headB= headB.next
        # return 
      
#######################################################################
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        lenA =  0
        curr = headA
        while curr != None:
            lenA += 1
            curr = curr.next

        lenB =  0
        curr = headB
        while curr != None:
            lenB += 1
            curr = curr.next

        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA
