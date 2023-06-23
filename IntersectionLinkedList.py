# Time Complexity : O(n) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to traverse the higher length list to same level of second low length list and return if two pointers are met.

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        temp1=headA
        lA=0
        while(temp1 is not None):
            temp1=temp1.next
            lA+=1
        temp2=headB
        lB=0
        while(temp2 is not None):
            temp2=temp2.next
            lB+=1
        
        p1=headA
        p2=headB
        while(lA<lB):
            p2=p2.next
            lB-=1
        while(lB<lA):
            p1=p1.next
            lA-=1
        
        while(p1!=None):
            if(p1==p2):
                return p1
            p1=p1.next
            p2=p2.next
            
        return p1