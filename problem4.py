class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
#         visited = set()
#         while headA:
#             visited.add(headA)
#             headA = headA.next
        
#         while headB:
#             if headB in visited:
#                 return headB
#             headB = headB.next
        
#         return None
        
        A = headA
        B = headB
        
        lena = 0
        lenb = 0
        
        while A:
            lena += 1
            A = A.next
        
        while B:
            lenb += 1
            B = B.next
        
        larger = headA
        smaller = headB
        l_larg = lena
        l_smal = lenb
        if lena<=lenb:
            smaller = headA
            larger = headB
            l_smal = lena
            l_larg = lenb
        

        while l_larg-l_smal > 0:
            larger = larger.next
            l_larg -= 1
        # print(larger, smaller, l_larg, l_smal)
        
        while smaller:
            if larger == smaller:
                return smaller
            larger = larger.next
            smaller = smaller.next