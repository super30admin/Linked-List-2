# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#Accepted on leetcode
#Time Complexity - O(m+n) as we are traversing through every node
#Space complexity - O(1) as we are simply creating two pointers

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if headA == None or headB == None:
            return None
        if headA == headB:
            return headA
        pointer1 = headA
        pointer2 = headB
        length1 = 0
        length2 = 0
        while pointer1 != None:
            length1 = length1 + 1
            pointer1 = pointer1.next
        pointer1 = headA
        while pointer2 != None:
            length2 = length2 + 1
            pointer2 = pointer2.next
        pointer2 = headB
        if length1 > length2:
            while length1 > length2:
                pointer1 = pointer1.next
                length1 = length1 - 1
        else:
            while length2 > length1:
                pointer2 = pointer2.next
                length2 = length2 - 1
        while pointer1 != pointer2:
            pointer1 = pointer1.next
            pointer2 = pointer2.next
        return pointer1