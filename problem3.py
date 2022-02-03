#Time Complexity = O(n)
#Space Complexity = O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        curr = headA
        while(curr!=None):
            lenA+=1
            curr=curr.next
            
        lenB = 0
        curr = headB
        while(curr!=None):
            lenB+=1
            curr = curr.next
        
        if(lenB>lenA):
            while(lenB!=lenA):
                lenB-=1
                headB=headB.next
        elif(lenA>lenB):
            while(lenA!=lenB):
                lenA-=1
                headA=headA.next
        while(headA and headB):
            if(headA==headB):
                return headA
            headA=headA.next
            headB = headB.next
        return None
            
        