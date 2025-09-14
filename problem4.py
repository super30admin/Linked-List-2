# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
"""
Space Complexity: O(1)
Time Complexity: O(m+n)
"""

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        len_a , len_b, curr_a, curr_b = 0, 0, headA, headB

        while curr_a: 
            curr_a = curr_a.next
            len_a+=1

        while curr_b: 
            curr_b = curr_b.next
            len_b+=1

        while len_a > len_b: 
            headA = headA.next
            len_a -=1

        while len_b > len_a:
            headB = headB.next
            len_b -=1

        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA
        
