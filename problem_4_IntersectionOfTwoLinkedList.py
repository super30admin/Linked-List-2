# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#time complexity O(n+m)---> n is length of 1st linked list, m is the lenght of 2nd linked list
#space copmlexity O(1)
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if (headA == None or headB == None):
            return None
        curr = headA
        lenA = 0
        
        #find lenght of 1st linked list
        while curr!= None:
            lenA = lenA+1
            curr = curr.next
            
        #find length of 2nd linked list
        curr = headB
        lenB = 0
        while(curr!= None):
            lenB = lenB +1 
            curr = curr.next
            
        #compare both linked list length
        while(lenA>lenB):
            headA = headA.next
            lenA = lenA-1
            
        while(lenB>lenA):
            headB = headB.next
            lenB = lenB -1
            
        while(headA != headB):
            headA = headA.next
            headB = headB.next
        return headA
            