#Time Complexity: O(n)
#Space Complexity: O(1), O(n) for method using set
#Leetcode: Yes

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        s = set()
        first, second = headA, headB
        while(first):
            if first is None and first.next:
                return
            
            s.add(first)
            first = first.next
        
        while(second):
            if second in s:
                return second
            
            if second is None:
                return
            
            second = second.next

    def getIntersectionNode_pointerMetod(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        first,second = headA,headB
        tmp1,tmp2 = headA,headB
        lenA, lenB = 0, 0
        while(first):
            lenA += 1
            first = first.next
            
        while(second):
            lenB += 1
            second = second.next
            
        if lenA == 1  and lenB == 1:
            if tmp1 == tmp2:
                return tmp1
        
        if lenA>lenB:
            diffA = lenA-lenB
            for i in range(diffA):
                tmp1 = tmp1.next
                
        if lenA<lenB:
            diffB = lenB-lenA
            for i in range(diffB):
                tmp2 = tmp2.next
               
        while tmp1 != tmp2:
            tmp1 = tmp1.next
            tmp2 = tmp2.next
        
        return tmp1