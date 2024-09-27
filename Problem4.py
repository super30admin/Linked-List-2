"""

    Student : Shahreen Shahjahan Psyche
    Time : O(L1 + L2) -> List1 and List2
    Space : O(1)

    This code ran successfully for all the test cases in Leetcode


"""

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        # edge case
        if not headA or not headB:
            return None
        
        # initilizing length variables
        len_headA = 0
        len_headB = 0
        temp_headA = headA
        temp_headB = headB
        
        # counting the length of A
        while(temp_headA):
            len_headA += 1
            temp_headA = temp_headA.next 
        
        # counting the length of B
        while(temp_headB):
            len_headB += 1
            temp_headB = temp_headB.next 
        
        # taking the difference
        difference = len_headA - len_headB
        
        # if difference is greater than 0, that means A is bigger, otherwise B is bigger
        # if difference is 0, then they are equal
        # will move the pointeer equal to difference steps
        if difference > 0:
            i = 0
            while(i<difference):
                headA = headA.next 
                i += 1
        
        if difference < 0:
            i = 0
            while(i<abs(difference)):
                headB = headB.next 
                i += 1
            
        # movinng the pointers together to reach the intersection at the same time
        while(headA and headB):
            
            if headA == headB:
                return headA
            headA = headA.next 
            headB = headB.next 
            
        
        return None
        
        