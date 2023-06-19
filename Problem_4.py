"""
Problem : 4

Time Complexity : O(m+n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

finding lengths of both the linked list, iterating the linked list having more length till the node where both the linked list has same length
then start comparing the nodes from both linked lists and incrementing the pointers until we reach the end, if intersection found, returning the
node, else returning None at the end of the code

"""

# intersection of two linked list

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
        # finding length of headA
        lenA=0
        curr=headA

        while curr:
            curr=curr.next
            lenA+=1
        
        # finding length of headB
        lenB=0
        curr=headB
        while curr:
            curr=curr.next
            lenB+=1
        
        
        if lenA<lenB:
            while lenB!=lenA:
                headB=headB.next
                lenB-=1
            while headB!=None or headA!=None:
                if headB==headA:
                    return headB
                else:
                    headB=headB.next
                    headA=headA.next

        elif lenA>lenB:
            while lenA!=lenB:
                headA=headA.next
                lenA-=1
            while headB!=None or headA!=None:
                if headB==headA:
                    return headB
                else:
                    headB=headB.next
                    headA=headA.next
        
        else:
            while headB!=None or headA!=None:
                if headB==headA:
                    return headB
                else:
                    headB=headB.next
                    headA=headA.next

        
        return None

