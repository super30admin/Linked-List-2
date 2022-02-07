class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        curA, curB = headA, headB
        a, b = 0, 0
        while curA:
            a+=1
            curA = curA.next
        while curB:
            b += 1
            curB = curB.next
        
        if a > b:
            curL = headA
            diff = a - b
            curS = headB
        else:
            curL = headB
            diff = b - a
            curS = headA
        i = 0
        while i < diff:
            i+= 1
            curL = curL.next
        while curL != curS:
            curL = curL.next
            curS = curS.next
            
        return curL


# T.C=>O(N * N) => Since we traverse whole linkedList,  and there might be case where we need to delete the last node from both merging list
# S.C=>O(1)
# Approach=>First we traverse through whole linkedListA and LinkedListB, then we get the length and difference and we can know which list is lond and which is small. 
#Here then we traverse till that node that makes the list of equal size. Ones then we traverse and check for thecommon node. Which can be deleted. 