# Time Complexity: O(n + m)
# Space Complexity: O(n)

class Solution:
    def getIntersectionNode(self, headA, headB):
        seen = set()
        a = headA
        while a:
            seen.add(a)
            a = a.next
        b = headB
        while b:
            if b in seen:
                return b
            b = b.next
        return None
