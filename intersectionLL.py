# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        '''
        x = set()
        while headA!=None:
            x.add(headA)
            headA = headA.next
        
        while(headB!=None):
            if(headB in x):
                return headB
            headB = headB.next
        
        return None
        '''
        '''
        Time: O(n)
        Space: O(1)
        '''
        m=0
        n=0
        temp1 = headA
        temp2 = headB
        while temp1!=None:
            m+=1
            temp1=temp1.next
        while temp2!=None:
            n+=1
            temp2=temp2.next
        
        while(m>n):
            headA = headA.next
            m-=1
        while(n>m):
            headB = headB.next
            n-=1
        
        while(headA!=None and headB!=None):
            if(headA==headB):
                return headA
            headA=headA.next
            headB=headB.next
        
        return None
