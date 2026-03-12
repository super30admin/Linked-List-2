#160. Intersection of Two Linked Lists

# Time  -> O(2n) -> O(n)
# Space -> O1
# Logic, go till end on both, if same node means connected. While going till last find the diff in length as well and what is bigger
# If connected then 1st move diff time on big lst, then start movig on both they'll meet on intersection 

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pointerA = headA
        pointerB = headB

        lengthDiff = 0
        listAIsBigger = False

        while pointerA.next!=None and pointerB.next!=None:
            pointerA=pointerA.next
            pointerB=pointerB.next
        if pointerA.next==None:
            while pointerB.next!=None:
                lengthDiff+=1
                pointerB=pointerB.next
        
        if pointerB.next == None:
            if pointerA.next!=None:
                listAIsBigger = True
            while pointerA.next!=None:
                lengthDiff+=1
                pointerA=pointerA.next
        
        if pointerA!=pointerB:
            # both pointers are at last elements, if they are not same means the lists are not connected
            return None
        if listAIsBigger:
            return self.findInterSection(headA,headB,lengthDiff)
        else:
            return self.findInterSection(headB,headA,lengthDiff)
        
    def findInterSection(self, bigListHead, smallListHead, lengthDiff):
        while lengthDiff>0:
            bigListHead=bigListHead.next
            lengthDiff-=1
        
        while bigListHead!=smallListHead:
            smallListHead=smallListHead.next
            bigListHead=bigListHead.next

        return bigListHead

