#Brute Force :
#Time Complexity : O(N)
#Space Complexity : O(N)

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
        d = {}
        current = headA
        search = headB
        while(current!=None):
            if current not in d:
                d[current] = 1
            current =current.next
        while (search !=None):
            if search in d:
                return search
            search = search.next
        return None
 =======================
 
 # Withoutspace
 
 #Time Complexity : O(N)
 #Space COmplexity :O(1)
 
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
        d = {}
        current = headA
        search = headB
        countA=1
        while(current!=None):
            current =current.next
            countA+=1
        
        countB=1
        while (search !=None):
            search = search.next
            countB+=1
            
        while(countA>countB):
            headA =headA.next
            countA-=1
            
        while(countB>countA):
            headB =headB.next
            countB-=1
            
        while headA!=headB:
            if headA!=headB:
                headA =headA.next
                headB = headB.next
        return headB 
            