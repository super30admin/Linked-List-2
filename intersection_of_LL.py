# O(M + N) TIME AND O(1) SPACE WHERE M,N ARE LENGTHS OF LLS

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None
        p1 = headA
        p2 = headB
        while p1 != p2:
            if p1 is None:
                p1 = headB
            elif p2 is None:
                p2 = headA
            
            else:
                p1 = p1.next
                p2 = p2.next
        return p1





        