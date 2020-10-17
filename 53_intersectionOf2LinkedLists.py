# Accepted on leetcode(160)
# time - O(n+m), space O(1)
#1. first calculate the length of both linked list.
#2. then make both the list same in length by changing the head position of list which is longer
#3. then comparing two lists of equal length to find intersection point.
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lenA = 0 # length variable for listA
        lenB = 0 # length variable for listB
        curr = headA # current pointer to iterate list
        while curr:
            lenA += 1
            curr = curr.next
        curr = headB
        while curr: # loop to calculate length
            lenB += 1
            curr = curr.next
        while lenA > lenB: # loop to calculate length of listB
            headA = headA.next
            lenA -= 1
        while lenB > lenA: # loop for making the lengths of equal length
            headB = headB.next
            lenB -= 1
        while headA != headB: # comparing 2 equal length lists to find intersection point
            headA = headA.next
            headB = headB.next
        return headA