# Time Complexity : O(n), n is no of nodes in the given list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# we are given two lists, now if they do intersect, we cant just move pointer at a time from both lists each
# mismatch in the length before the intersecting node might not let us catch it
# so we have to make the length same, and then we can move the pointers one by one, and compare if they are the same nodes
# so we find the length of both lists
# which ever is longer, we move a pointer from the head m no of times, where m is the difference in the lengths of both lists
# then we can move currA and currB at the same pace and check if they ever reach the same node


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
        if headA is None or headB is None:
            return None
        
        # finding lenA
        currentA = headA
        lenA = 0

        while (currentA is not None):
            lenA += 1
            currentA = currentA.next

        # finding lenB
        currentB = headB
        lenB = 0
        while (currentB is not None):
            lenB += 1
            currentB = currentB.next
        
        # reseeting the pointers
        currentA = headA
        currentB = headB

        if lenA > lenB:
            diff = lenA - lenB
            count = 0
            # moving currA because list A is longer
            while (count != diff):
                currentA = currentA.next
                count += 1
            
        else:
            diff = lenB - lenA
            count = 0
            # moving currB because list B is longer
            while (count != diff):
                currentB = currentB.next
                count += 1
        
        while (currentA != None or currentB != None):
            # intersecting node
            if currentA == currentB:
                return currentA

            currentA = currentA.next
            currentB = currentB.next
        
        return None
