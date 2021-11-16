#Time Complexity : O(m+n)
#Space Complexity : O (1)
#Did this code successfully run on Leetcode : yes
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:  
        lenA = 0
        lenB = 0
        
        # calculate length for both linked lists
        currA = headA
        while currA:
            lenA = lenA+1
            currA = currA.next
        
        currB = headB
        while currB:
            lenB = lenB + 1
            currB = currB.next
        
        # reset pointer back to start of the linked lists
        currA = headA
        currB = headB
        
        # the possibility of the intersection (if any) will be within the length of the shorter linked list
        # so skip through the longer list until the lengths match
        if lenA > lenB:
            while lenA != lenB:
                lenA = lenA-1
                currA = currA.next
        else:
            while lenA != lenB:
                lenB = lenB-1
                currB = currB.next
        
        # once the remaining lengths for both linked lists are same, compare each of the nodes
        while lenA > 0:
            if currA == currB:
                return currA
            currA = currA.next
            currB = currB.next
            lenA = lenA-1
        
        return