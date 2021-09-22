# Time Complexity : O(m+n) if there are m elements in list A and n elements in list B
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach: 

# traverse both lists and get their lengths
# then which ever list has greater length, traverse that list 
# until their lengths become equal
# from there on keep advancing the pointer in both lists till the pointer points to
# the same element in both lists


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = None

class Solution:

    def getIntersectionNode(self, headA, headB):

        if not headA or not headB:
            return None
        
        pa = headA
        pb = headB
        counta = 0
        countb = 0
        
        while pa is not None:
            counta += 1
            pa = pa.next

        while pb is not None:
            countb += 1
            pb = pb.next

        pa = headA 
        pb = headB

        if counta > countb:
            while counta != countb:
                counta -= 1
                pa = pa.next
        
        if countb > counta:
            while counta != countb:
                countb -= 1
                pb = pb.next
            
        while pa != pb:
            pa = pa.next
            pb = pb.next
        
        return pa
                




