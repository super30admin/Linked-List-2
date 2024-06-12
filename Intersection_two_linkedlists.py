// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
1.we take the total length of both the linkedlists and then subtract their lengths to see which one is the largest one.
2.For the largest linked list we traverse by the difference of the both linkedlists.
3.From that point we start traversing both the linked lists till the pointers on both the linked list reach a common point.

# Time complexity --> o(m+n) m is the length of first linked list and n is the length of the second linked list
# space complexity --> o(1)
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
        count1=0
        count2=0
        temp=headA
        temp1=headB
        while(temp!=None):
            temp=temp.next
            count1=count1+1
        while(temp1!=None):
            temp1=temp1.next
            count2=count2+1
        rem=abs(count1-count2)
        if count1>count2:
            while(rem>0):
                headA=headA.next
                rem=rem-1
        else:
            while(rem>0):
                headB=headB.next
                rem=rem-1
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        return headA