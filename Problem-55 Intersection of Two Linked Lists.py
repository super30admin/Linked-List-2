# 160. Intersection of Two Linked Lists
# https://leetcode.com/problems/intersection-of-two-linked-lists/

# Time Complexity: O(m+n)
# Space Complexiety: O(1)

# Logic: Every node from the point of intersection will be common in both the LL. 
# Hence the difference in length of the LL will be before the point of intersection. 
# We calculate the lengths for both the LL and then move the head with more length 
# such that now both the head are equally placed. Iterate both the LL and return point of intersection.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None
        
        l1 = 0
        l2 = 0
        
        ptr = headA
        while ptr:
            l1 += 1
            ptr = ptr.next
        
        ptr = headB
        while ptr:
            l2 += 1
            ptr = ptr.next
        
        while l1 < l2:
            headB = headB.next
            l2 -= 1
        
        while l1 > l2:
            headA = headA.next
            l1 -= 1
        
        while headA:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        return None