# Approach:
# The function `getIntersectionNode` finds the intersection point of two singly linked lists, if one exists.
# 1. Two pointers `l1` and `l2` are initialized to the heads of the two lists.
# 2. Each pointer traverses its respective list. When a pointer reaches the end of its list, it is redirected 
#    to the head of the other list. This ensures that both pointers travel the same distance, accounting for any 
#    difference in the lengths of the two lists.
# 3. If there is an intersection, the pointers will eventually meet at the intersection node. If not, they will 
#    both reach the end (`None`) at the same time, and `None` will be returned.
# 
# Time Complexity:
# - O(m + n), where m is the length of `headA` and n is the length of `headB`. Both lists are traversed at most twice.
# 
# Space Complexity:
# - O(1), as the algorithm uses only constant extra space for the pointers.

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        l1, l2 = headA, headB
        while l2 != l1:
            l1 = l1.next if l1 else headB
            l2 = l2.next if l2 else headA
        
        return l1
