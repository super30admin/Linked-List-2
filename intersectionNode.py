# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#Accepted on leetcode
#Time Complexity - O(n) as we are traversing through every node
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
        temp1 = headA
        temp2 = headB
        while temp1 != temp2:
            if temp1 == None:
                temp1 = headB
            else:
                temp1 = temp1.next
            if temp2 == None:
                temp2 = headA
            else:
                temp2 = temp2.next
        return temp1
        