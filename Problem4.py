#Time Complexity :- O(N+M) N os the size of first list and M is the size of second list 
#Space Complexity :- O(1)
#Approach :- we have used a count and checked which list is greater and once that is done we move the bigger list and then start matching the reference.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        listA = headA
        listB = headB
        countA = 0
        countB = 0
        while listA:
            countA +=1
            listA = listA.next
        while listB:
            countB +=1
            listB = listB.next
        
        if countA > countB:
            bigCount = countA-countB
            for i in range(bigCount):
                headA = headA.next
        else:
            bigCount = countB-countA
            for i in range(bigCount):
                headB = headB.next

        while headA:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        return None