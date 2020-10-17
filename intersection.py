"""
HASH TABLE APPROACH/TWO POINTER APPROACH:
Time: O(m+n)
Space: O(m+n)
Leet: Accepted
Problems: None
"""

####DICT SOLUTION####
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        dict1 ={}  #DICT
        head1 = headA
        head2 = headB
        while head1 is not None: #Add to dict
            dict1[head1] = "visited"
            head1 = head1.next

        while head2 is not None:
            if head2 in dict1: #if found in dict return
                return head2
            head2 = head2.next

        return None



####TWO PTR SOLUTION####
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        a_ptr = headA
        b_ptr = headB
        jump = False #Keeps track of whether jump has happened

        while a_ptr is not None and b_ptr is not None:
            if a_ptr == b_ptr: #found intersection
                return a_ptr
            a_ptr, b_ptr = a_ptr.next, b_ptr.next
            if a_ptr is None and not jump: #If A reaches end and jump hasn't happened
                a_ptr = headB #start A pointer on head of B
                jump = True #set jump to True
            if b_ptr is None:
                b_ptr = headA #start B_pointer on head of A if B has reached end of list
        return None
