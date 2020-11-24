#timecomplexity O(max(m,n)) m and n is the length of the list
#spacecomplexity O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Find length of both lists, the whichever list is longer, start iterating from there till the difference of the lengths of the two linkedlist. This will bring both pointers to the same distance from the intersecting node. Then start iterating both linkedlists and where they meet is where they intersect.
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA=0
        lenB=0
        tempA=headA
        tempB=headB
        
        while tempA!=None :
            lenA+=1
            tempA=tempA.next
        while tempB!=None :
            lenB+=1
            tempB=tempB.next
        diff=abs(lenA-lenB)
        #
        if lenA>lenB:
            while lenA!=lenB:
                lenA-=1
                headA=headA.next
        else:
            while lenA!=lenB :
                lenB-=1
                headB=headB.next
        while headA!=headB :         
            headA=headA.next
            headB=headB.next
     
        return headA
            
        
        
        
        
      
      