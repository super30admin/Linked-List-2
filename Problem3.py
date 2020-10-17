# Time Complexity : Having trouble with it. Can you please explain this?
# Space Complexity :maybe O(n) but not sure
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : Yes. Can you tell me the proble in the code that I have commented. It is giving me error.



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
        n1 = headA
        n2 = headB

        while n1 != n2:
            if n1 != None:
                n1 = n1.next
            else:
                n1 = headB

            if n2 != None:
                n2 = n2.next
            else:
                n2 = headA
        return n1


        # n1 = headA
        # n2 = headB
        #
        # while n1 != n2:
        #
        #     n1 = n1.next
        #     n2 = n2.next
        #     if n1 is None:
        #         n1 = headB
        #     if n2 is None:
        #         n2 = headA
        #
        # return n1


# in this problem I have initally soted the heads of both the link list in n1 and n2. Then I am iterationg over the lists
# and am creating a looping by connectiong the end of linked list to each other when an end of any link list is encountred.