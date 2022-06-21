# time complexity is o(m + n), where m,n is the size of given linkedlists.
# space complexity is o(1).
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1 = 0
        l2 = 0
        p1 = headA
        p2 = headB
        while(p1):
            l1 += 1
            p1 = p1.next
        while(p2):
            l2 += 1
            p2 = p2.next
        p1 = headA
        p2 = headB
        while(l1 > l2):
            p1 = p1.next
            l1 -= 1
        while(l2 > l1):
            p2 = p2.next
            l2 -= 1
        if(p1 == p2):
            return p1
        flag = False
        while(p1 != None and p1 != p2):
            p1 = p1.next 
            p2 = p2.next
            if(p1 == p2):
                flag = True
        if(flag):
            return p1
        else:
            return None
        
            
            
            