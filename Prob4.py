#Time complexity: O(n)
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        lenA,lenB = 0,0
        curr = headA
        
        #find length of list A
        while curr.next is not None:
            lenA +=1
            curr = curr.next
        
        curr = headB
        # find length of list B
        while curr.next is not None:
            lenB +=1
            curr = curr.next
        
        # if B is longer, take B's head at same position
        while lenA < lenB:
            lenB -= 1
            headB = headB.next
        # if A is longer, take A's head at same position
        while lenA > lenB:
            lenA -= 1
            headA = headA.next
        # when at same position, move both, they will meet at intersection point
        # when no intersection, both would become None and equal, handles the edge case
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA
        
        