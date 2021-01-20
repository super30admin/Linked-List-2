# Created by Aashish Adhikari at 4:19 PM 1/19/2021

'''
Time Complexity:
O(max (m,n)) since we iterate through both the linked lists.

Space Complexity:
O(1) since we are using a constant number of variables regardless of the lengths of the linked lists.
'''

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


        leng1 = 0
        leng2 = 0

        # find the lengths of both LLs
        curr = headA
        while curr != None:
            leng1 += 1
            curr = curr.next

        curr = headB
        while curr != None:
            leng2 += 1
            curr = curr.next


        while leng1 > leng2:

            headA = headA.next
            leng1 -= 1

        while leng2 > leng1:

            headB = headB.next
            leng2 -= 1

        while headA != headB: #<-- dont have to take the values but the nodes themeselves, they refer to memory locations
            headA = headA.next
            headB = headB.next

        return headA


