class ListNode:
    def __init__(self,x):
        self.val=x
        self.next=None

class Solution:
    def getIntersectionNode(self,headA,headB):
        if not headA or not headB:
            return None
        
        pA,pB=headA,headB

        while pA!=pB:
            pA=pA.next if pA else headB
            pB=pB.next if pB else headA

        return pA
    
def buildIntersectionLists(intersectVal,listA,listB,skipA,skipB):
    nodesA=[ListNode(val) for val in listA]
    nodesB=[ListNode(val)for val in listB]

    for i in range(len(nodesA)-1):
        nodesA[i].next=nodesA[i+1]
    for i in range(len(nodesB)-1):
        nodesB[i].next=nodesB[i+1]

    if intersectVal !=0:
        intersect_node=nodesA[skipA]
        nodesB[skipB-1].next=intersect_node

    headA=nodesA[0] if nodesA else None
    headB=nodesB[0] if nodesB else None
    return headA,headB

intersectVal=8
listA=[4,1,8,4,5]
listB=[5,6,1,8,4,5]
skipA=2
skipB=3

headA,headB=buildIntersectionLists(intersectVal,listA,listB,skipA,skipB)
sol=Solution()
intersection_node=sol.getIntersectionNode(headA,headB)

print("Intersected at:",intersection_node.val if intersection_node else "No Intersection")