# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        tempA=headA
        tempB=headB
        count1=0
        count2=0
        while tempA!=None:
            count1+=1
            tempA=tempA.next
        
        while tempB!=None:
            count2+=1
            tempB=tempB.next
        
        print("count1"+str(count1))
        print("count2"+str(count2))
        
        while count1>count2:
            headA=headA.next
            count1-=1
        
        while count2>count1:
            headB=headB.next
            count2-=1

        print("headA"+str(headA.val))
        print("headB"+str(headB.val))
        
        while headA!=headB:
            headA=headA.next
            headB=headB.next

        return headA


        

        