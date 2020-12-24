# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Approach:
# IN this apporach we will first get the length of both list. After getting lengths, we will adjust the head pointers such that both of them travel at the same ith node on both list. In that case what will happen is while iterating and comparing the references of both the list together, if there is an interesection we stop the iteration and return either of pointers else it will retrun none

# Time Complexity: O(m+n)
# Space Complexity: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        if headA == None:
            return 
        if headB == None: 
            return 
        
        lenA = 0
        lenB = 0
        
        curr = headA
        while curr:
            curr = curr.next
            lenA += 1
        
        curr = headB
        while curr:
            curr = curr.next
            lenB += 1
            
        while (lenA < lenB):
            headB= headB.next
            lenB -= 1
            
        while (lenB < lenA):
            headA= headA.next
            lenA -= 1
            

        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headB
        
        
        