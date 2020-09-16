// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return
        sizeA=0
        sizeB=0
        dummyA=headA
        dummyB=headB
        while dummyA!=None:
            sizeA+=1
            dummyA=dummyA.next
        while dummyB!=None:
            sizeB+=1
            dummyB=dummyB.next
        dummyA=headA
        dummyB=headB
        #find difference between lengths and move the head of the larger list.
        if sizeA>sizeB:
            move=sizeA-sizeB
            for i in range(move):
                dummyA=dummyA.next
        elif sizeB>sizeA:
            move=sizeB-sizeA
            for i in range(move):
                dummyB=dummyB.next
        print(dummyA.val,dummyB.val)
        #find intersection, if present.
        while dummyA and dummyB:
            if dummyA==dummyB:
                return dummyA
            dummyA=dummyA.next
            dummyB=dummyB.next
            
        return dummyA
        

            