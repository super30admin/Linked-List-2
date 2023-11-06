# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#Tc: O(n*m) n is length of one list, m is length of another list
#Sc: O(1)
#BRUTE FORCE
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        while headA is not None:
            pB = headB
            while pB is not None:
                if headA == pB:
                    return headA
                pB = pB.next
            headA = headA.next

        return None

#HASHSET!
#Tc: O(n+m) n is length of one list, m is length of another list
#Sc: O(m), m is space occupied by set
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        nodes_in_B = set()

        while headB is not None:
            nodes_in_B.add(headB)
            headB = headB.next

        while headA is not None:
            # if we find the node pointed to by headA,
            # in our set containing nodes of B, then return the node
            if headA in nodes_in_B:
                return headA
            headA = headA.next

        return None

#TC: O(n+m), n is length of one list, m is length of another list
#SC: O(1)
#no hashset!
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        lenA = 0
        lenB = 0
        
        curr = headA
        while curr:
            curr = curr.next
            lenA += 1
            
        curr = headB
        while curr:
            curr = curr.next
            lenB += 1
            
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
            
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
            
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        return headA

#TC: O(n+m), n is length of one list, m is length of another list
#SC: O(1)
#just a fancy way of doing the above one
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        pA = headA
        pB = headB

        while pA != pB:
            pA = headB if pA is None else pA.next
            pB = headA if pB is None else pB.next

        return pA
        
        