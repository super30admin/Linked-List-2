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
        
        
        

