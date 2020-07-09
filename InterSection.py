# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        curr=headA
        lenA=0
        lenB=0
        while(curr!=None):
            curr=curr.next
            lenA+=1
        curr=headB
        
        
        while(curr!=None):
            curr=curr.next
            lenB+=1
        
        while(lenA>lenB):
            headA=headA.next
            lenA-=1
        while(lenA<lenB):
            headB=headB.next
            lenB-=1
        
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        return headA
        
        
 #Time is O(m+n)
 #Space is O(1)
