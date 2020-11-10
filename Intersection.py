# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        A = headA
        B = headB
        first = 0
        second = 0
        if not A or not B:
            return None
        while A:
            A = A.next
            first += 1
        while B:
            B = B.next
            second +=1

        A = headA
        B = headB
        while first<second:
            B = B.next
            second-=1
        while second<first:
            A = A.next
            first-=1
        
        while A.next and A!=B:
            A = A.next
            B = B.next
        
        return A if A==B else None

# Time complexity : O(m+n)

# Space complexity : O(1)