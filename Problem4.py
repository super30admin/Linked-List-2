## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

# Approach
# set p1, p2 at head of list 1 and 2 respectively. Get length of both LinkedList. If listA > listB: while (listA > listB), increment headA pointer and decrement length
# This will give us equivalent starting point for both the list from the intersection. Similarly, if listB is bigger than listA, increment headB and decrement len
# while(headA != headB), increment both. return headA 

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        p1 = headA
        p2 = headB
        lenA = 0
        lenB = 0
        
        while(p1!=None):
            p1 = p1.next
            lenA += 1
     
            
        while(p2 != None):
            p2 = p2.next
            lenB += 1
 
        
        if lenA > lenB:
            while(lenA>lenB):
                headA = headA.next
                lenA -= 1
        else:
            while(lenB>lenA):
                headB = headB.next
                lenB -= 1    
        
        while(headA != headB):
            headA = headA.next
            headB = headB.next
    
        return headA