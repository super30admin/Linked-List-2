# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#time - O(n)
#space - O(1)


class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # j=LheadA
        count_A = 0  # length of A
        k = headA
        h = headB
        while k:
            count_A += 1
            k = k.next

        # count_A += 1
        count_B = 0
        while h:
            count_B += 1
            h = h.next
        # count_B += 1
        j = count_A - count_B
        k = headA
        h = headB
        # print(count_A,count_B)
        if j > 0:
            # print(j,'jjjj')
            i = 0

            while i < abs(j):
                k = k.next
                i += 1
        else:
            # print(j,'jjjj')
            i = 0

            while i < abs(j):
                h = h.next
                i += 1
        while h and k:
            if h == k:
                return h
            else:
                h = h.next
                k = k.next
        return