"""
Intuition: 
Brute Force: Use a hashmap to store the elements of the list with higher elements

Optimized: Count the length of both linked lists.
Get the difference between the 2 lengths move the higher linked list pointer with the difference.
Move the 2 pointers with the same speed.

#####################################################################
Time Complexity : O(M+N) where M = length of the first linked list, N = length of the second linked list 
Space Complexity : O(1)
#####################################################################

"""

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        lenA = 0
        lenB = 0
        ptr1 = headA
        while ptr1 != None:
            ptr1 = ptr1.next
            lenA += 1
        
        ptr2 = headB
        while ptr2 != None:
            ptr2 = ptr2.next
            lenB += 1
            
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        
        while headA != headB:
            headB = headB.next
            headA = headA.next
        return headB
            
        
            
            