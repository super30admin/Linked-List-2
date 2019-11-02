# leetcode:accepted
# time complexity: o(N)
# space complexity: O(1)
# no doubts
# explination:
# you need to find the enght of the two linkedlist
# make sure the two linkedlist are pointing to the point;
# iterate through both the linkedlist until youn find intersection


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
        lenA = 0
        lenB = 0
        currA = headA
        currB = headB

        # finding the lenght of the linkedlist A
        while (currA != None):
            # print(currA)
            currA = currA.next
            lenA += 1

        # finding the length of the linkedlist B
        while (currB != None):
            currB = currB.next
            lenB += 1
        # if lnkedlist A is longer than B, move head A such that len(head A --- end )is equal to the len  of B
        while (lenA > lenB):
            headA = headA.next
            lenA -= 1
        # repeat the same if linkedlist B is longer than A
        while (lenB > lenA):
            headB = headB.next
            lenB -= 1

        # keep on shifting until the values of the two pointer becomes the same
        while (headA != headB):
            headA = headA.next
            headB = headB.next
        return headA

