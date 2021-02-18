"""160. Intersection of Two Linked Lists
Time Complexity - O(max(A,B))
Space Complexity - O(1)
Calculate length of A and B LinkedList
Check which LinkedList length as longer, then bring header in cor-ordination with second LinkedList
Check each and every element in this list and if node matches return node"""
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        dummyA = headA
        dummyB = headB
        sizeA = 0
        sizeB = 0
        "Length of A"
        while dummyA != None:
            dummyA = dummyA.next
            sizeA += 1
        "Length of B"
        while dummyB != None:
            dummyB = dummyB.next
            sizeB += 1
        
        dummyA = headA
        dummyB = headB
        if (sizeA > sizeB):
            while(sizeA != sizeB):
                sizeA -= 1
                dummyA = dummyA.next
        else:
            while(sizeA != sizeB):
                sizeB -= 1
                dummyB = dummyB.next
        
        while(dummyA != None and dummyB != None and dummyA != dummyB):
            dummyA = dummyA.next
            dummyB = dummyB.next
        return dummyA