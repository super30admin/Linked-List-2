#Time Complexity:O(m+n)
#Space Complexity:max(O(m),O(n))

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        hashsetB=set()
        while headB:
            hashsetB.add(headB)
            headB=headB.next
        while headA:
            if headA in hashsetB:
                return headA
            headA=headA.next
        return None

#Optimized Approach
#Time Complexity:O(m+n)
#Space Complexity:O(1)

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA=0
        lenB=0
        currA=headA
        while currA:
            lenA+=1
            currA=currA.next
        currB=headB
        while currB:
            lenB+=1
            currB=currB.next
        while lenA>lenB:
            headA=headA.next
            lenA-=1
        while lenB>lenA:
            headB=headB.next
            lenB-=1
        while headA!=headB:
            headA=headA.next
            headB=headB.next
        return headA
        

        
