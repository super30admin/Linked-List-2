#Time complexity: O(m+n) - max of m and n (two LL's)
#Space complexity; O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        lenA = 0
        itr = headA
        while itr:
            lenA += 1
            itr = itr.next
        
        lenB = 0
        itr = headB
        while itr:
            lenB += 1
            itr = itr.next
        
        print(lenA, lenB)
        
        
        if lenA > lenB:
            while lenA > lenB:
                headA = headA.next
                lenA -= 1
        
        if lenB > lenA:
            while lenB > lenA:
                headB = headB.next
                lenB -= 1
                
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA
        