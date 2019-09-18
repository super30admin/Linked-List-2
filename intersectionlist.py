# leetcode: failute
# timecomplexity: O(m+n)
# no ddoubts
# code not executed

# expliantion:
# 1. take the lenghts of the two lists
# 2. find the differnece between the two lenghts as diff
# 3. traverse the longer list n times
# 4. checks the values of the node
# 5. If the values are same, return it


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
        p1 = headA
        p2 = headB
        lenA = 0
        lenB = 0
        # finding length of A
        while (p1 != None):
            p1 = p1.next
            lenA += 1
        # finding length of B
        while (p2 != None):
            p2 = p2.next
            lenB += 1
        # finding the diffrence betwee the two lenghts
        diff = abs(lenA - lenB)
        print(lenA, lenB)
        # print(p2.val)

        # traversing the longest list "diff" times
        if lenA > lenB:
            while (diff > 0):
                p1 = p1.next
                print("first is longer")
                diff = diff - 1
        if lenB > lenA:
            print("move {} times".format(diff))
            while (diff > 0):
                print("second is longer")
                p2 = p2.next
                diff = diff - 1
                # checking if p1.val same as p2.val
        while (p1.val == p2.val):
            p1 = p1.next
            p2 = p2.next
        return p1.val
