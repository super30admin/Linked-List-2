#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        currA = headA
        currB = headB
        len1,len2 = 0,0
        
        while currA:
            len1+=1
            currA = currA.next
            
        while currB:
            len2+=1
            currB = currB.next
        
        diff = abs(len1-len2)
        count = 0
        print(len1,len2)
        if len1>len2:
            while count<diff:
                headA = headA.next
                count += 1
                
        if len2>len1:
            while count<diff:
                headB = headB.next
                count += 1
                
        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next
        return None
            
            
            