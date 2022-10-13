# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# store pointer of LL in hashset and compare with other LL if found return the intersection
# TC & SC - O(m+n)


# Optimized--> Two pointers start from head of both LL, whichever is longer move that pointer to make equidistance from intersection and then compare and increase both pointers
# TC- O(m+n) & SC - O(1)


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        cur = headA
        #make eual len
        while cur != None:
            lenA += 1
            cur = cur.next
        cur = headB
        while cur != None:
            lenB += 1
            cur = cur.next
            
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
            
        while lenA < lenB:
            headB = headB.next
            lenB -= 1
        
        #compare both LL
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA
        