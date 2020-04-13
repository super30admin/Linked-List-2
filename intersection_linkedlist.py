"""
// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
We compute the lengths of both the lists and cover the gap based on the bigger length
by advancing head pointer untill they meet
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def get_length(self,head):
        curr = head
        lt = 0
        while curr:
            lt+=1
            curr = curr.next
        return lt
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        
        lenA = self.get_length(headA)
        lenB = self.get_length(headB)
        
        #advance the headA untill lenA - lenB > 0
        while lenA > lenB:
            headA = headA.next
            lenA-=1
        
        #advance the headB untill lenB - lenA > 0
        while lenB > lenA:
            headB = headB.next
            lenB-=1
        
        #Advance headA and headB until intersection point
        while headA!=headB:
            headA = headA.next
            headB = headB.next
        return headA