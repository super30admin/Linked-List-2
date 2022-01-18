#Time Complexity O(N)
#Space Complexity O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        len_a = 0
        len_b = 0
        cur = headA
        while cur !=None:
            cur = cur.next
            len_a+=1
        cur = headB
        
        while cur!=None:
            cur = cur.next
            len_b +=1
        while len_a >len_b:
            headA  = headA.next
            len_a -=1
        while len_b> len_a:
            headB  = headB.next
            len_b -=1
        
        while headA !=headB:
            headA = headA.next
            headB = headB.next
        
        return headA
        
            
        
        
