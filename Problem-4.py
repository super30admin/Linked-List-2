# 160. Intersection of Two Linked Lists
'''
Leetcode all test cases passed: Yes
Solution:
    
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        n is the no of nodes in headA
        m is the no of nodes in headB
        Space Complexity: O(1) 
        Time Complexity: O(m + n)
'''
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        len_a = 0
        len_b = 0
        a = headA
        b = headB
        while a != None:
            len_a += 1
            a = a.next
        
        while b != None:
            len_b += 1
            b = b.next
        
        a = headA
        b = headB
        while len_a > len_b:
            a = a.next
            len_a -= 1
        
        while len_b > len_a:
            b = b.next
            len_b -= 1
        
        while a != b:
            a = a.next
            b = b.next
        
        return a
