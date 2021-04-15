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
        # Time Complexity is O(n)
        # Space Complexity is O(1)
        # Count the number of nodes in List1 and List2
        # Compute the difference and make them point to equal distance till end
        origA = headA
        origB = headB
        n1 = 0
        while(headA):
            n1+=1
            headA = headA.next
        
        n2 = 0
        while(headB):
            n2+=1
            headB = headB.next
        
        headA = origA
        headB = origB
        while(n1 > n2):
            headA = headA.next
            n1-=1
            
        while(n2 > n1):
            headB = headB.next
            n2-=1
        
        while(headB and headA and headA != headB):
            #print("s")
            headA = headA.next
            headB = headB.next
        
        return headA