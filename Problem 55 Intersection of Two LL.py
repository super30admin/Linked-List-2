# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(1)
# Logic: if two pointers are standing on their respective heads, keep on moving each pointer until one becomes null, at
# point the pointer to other's head & do the same for other pointer as well. mathmatically after 2 traversal they will
# reach intersection point or null. for ex: a len of 1st, b len of 2nd & c is the len of common portion so for both
# pointer after 2 traversal length would be a + b + c at intersection point.

class Solution:
    def getIntersectionNode(self, headA, headB):
        a = headA
        b = headB
        while a != b:
            if a:
                a = a.next
            else:
                a = headB
            if b:
                b = b.next
            else:
                b = headA
        return a
