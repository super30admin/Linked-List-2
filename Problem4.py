#Time complexity is: O(max(la,lb))
#Space complexity is: O(1) 
#Code ran successfully on geeks for geeks
#Faced no issues while coding this problem

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
        #la is length of the first linked list
        la=0
        current=headA
        #calculating the length of the first linked list
        while(current!=None):
            la+=1
            current=current.next
        
        #lb is the length of the second linked list
        lb=0
        current=headB
        #Calculating length of the second linked list
        while(current!=None):
            lb+=1
            current=current.next
        
        #If la>lb, we will move first linked list pointer by la-lb poistions
        while(la>lb):
            la-=1
            headA=headA.next
        
        #If lb>la, we will move first linked list pointer by lb-la poistions
        while(lb>la):
            lb-=1
            headB=headB.next
        #After that we will move both pointers at a time until they meet 
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        return headA
