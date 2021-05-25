# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA == headB:
            return headA
        i = 0
        headA2 = headA
        headB2 = headB
        while(headA2!=None):
            i = i + 1
            headA2 = headA2.next
        j =0
        while(headB2!=None):
            j = j + 1
            headB2 = headB2.next

        if i>j:
            val = i - j
            while(val!=0):
                headA = headA.next
                val = val - 1
        else:
            val = j - i
            while(val!=0):
                headB = headB.next
                val = val - 1
        while(headA !=None):
            if(headA==headB):
                return headA
            headA = headA.next
            headB = headB.next

        return None

        
