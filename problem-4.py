#tc: O(n)
#sc: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        m = 0
        n = 0
        temp = headA
        while temp:
            temp = temp.next
            m += 1
        temp = headB
        while temp:
            temp = temp.next
            n += 1
        if  m > n:
            while m != n:
                m -= 1
                headA = headA.next
        else:
            while m != n:
                n -= 1
                headB = headB.next
            
        while headA is not headB:
            headA = headA.next
            headB = headB.next
        return headA