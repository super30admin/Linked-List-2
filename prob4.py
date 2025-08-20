# Intersection of two linked list
# First we're iterating through the first linked list and identifying the count of nodes A and B.
# Based on the count, we are iterating the linkedlist with higher count by the difference of counts.
# Then we are iterating both linked lists together until we find the intersection node.
# If we reach the end of either linked list without finding an intersection, we return None.
# Time Complexity: O(A + B)
# Space Complexity: O(1)

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
        listA,listB = headA, headB
        countA,countB = 0,0
        while listA:
            countA+=1
            listA = listA.next
        while listB:
            countB+=1
            listB = listB.next
        listA,listB = headA, headB
        while countA>countB:
            listA = listA.next
            countA-=1
        while countB>countA:
            listB = listB.next
            countB-=1
        while listA!=listB:
            listA = listA.next
            listB = listB.next
        return listB 
        
# We're traversing both linked lists simultaneously, switching to the other list when we reach the end of one.
# This way, both pointers will meet at the intersection node if it exists, or at None
# Time Complexity: O(A + B)
# Space Complexity: O(1)
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        listA,listB = headA, headB
        while listA!=listB:
            listA = listA.next if listA else headB
            listB = listB.next if listB else headA
        return listA