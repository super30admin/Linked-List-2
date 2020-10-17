# Leet code -160 ( Intersection of two linked lists)
# Time complexity - O(M+N)
#space complexity-O(1)
# Approach = we need to have pointer A and Pointer B. When pointer A becomes null, we need to intialize is to head node of B. When pointer B becomes Null then we need to intialize is to head node of A.  we need to return that node, when both the pointers meet.



# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if headA==None or headB == None:
            return None
        pointer_A=headA
        pointer_B=headB
        
        while pointer_A!=pointer_B:
            if pointer_A==None: 
                pointer_A=headB
            else:
                pointer_A=pointer_A.next
            
            if pointer_B==None: 
                pointer_B=headA
            else:
                pointer_B=pointer_B.next
        return pointer_A
        
        
# using hash_set

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if headA==None or headB == None:
            return None
        hash_set=set()
        while headA!=None:
            hash_set.add(headA)
            headA=headA.next
        
        while headB!=None:
            if headB in hash_set:
                return headB
            else:
                headB=headB.next
        return None
    
# optimal solution - Time complexity -O(N), space -O(1)
# Approach - We will traverse both headA and headB and we calculate the length of both A and B. If length of headA is greater than length of headB, then we increment the headA till the difference and we going forward were both the pointers meet.

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
       
        if headA==None or headB == None:
            return None
        len_A=0
        len_B=0
        cur_A=headA
        cur_B=headB
        while cur_A!=None:
            cur_A=cur_A.next
            len_A+=1
        
        while cur_B!=None:
            cur_B=cur_B.next
            len_B=len_B+1
        
        for i in range(abs(len_A-len_B)):
            if len_A>len_B:
                headA=headA.next
            else:
                headB=headB.next
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        return headA

