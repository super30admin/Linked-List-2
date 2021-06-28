# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
"""
Using pointers: Find length of two LLL and cover the gap by moving head of longer linked list
          Once heads of both linked lists are equidistant from intersecting point, keep 
          incrementing them until they become equal. 
          Heads equal means intersection point reached
          Then you can return either headA/headB          
"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        curr=headA
        lenA=0
        lenB=0
        #finding lengths
        while curr!=None:
            lenA+=1
            curr=curr.next

        curr=headB         #reset current to head B to get 2nd LLL length
        while curr!=None:
            lenB+=1
            curr=curr.next

        #making heads equidistant from intersection point
        while (lenA>lenB):
            headA=headA.next
            lenA-=1

        while (lenB>lenA):
            headB=headB.next
            lenB-=1

        #once heads are equidistant, increment them until they are equal
        while (headA!=headB):
            headA=headA.next
            headB=headB.next

        return headA #can return either headA or headB

