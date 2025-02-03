# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#--------------------Time = O(n+m), Space = O(1)---------------------------
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None:
            return None
        lenA = 0
        curr = headA
        while curr != None: # Calculate len of first LL
            lenA += 1
            curr =  curr.next
        
        lenB = 0
        curr = headB
        while curr != None: # Calculate len of second LL
            lenB += 1
            curr = curr.next
        
        while lenB > lenA: # if lenB>lenA give move the head of LL B until it becomes equal to lenA
            headB = headB.next
            lenB -= 1
        
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        
        while headA != headB: # Now just check the intersection by moving heads of both LL
            headA = headA.next
            headB = headB.next
        
        return headA