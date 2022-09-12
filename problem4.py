'''
160. Intersection of Two Linked Lists
APPROACH 1: using set
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTY: Nope

APPROACH 2: Two pointer - Diff approach
TIME COMPLEXITY: O(N) + O(N) = O(N)
SPACE COMPLEXITY: O(1)
LEETCODE: Yes
DIFFICULTY: A bit, but could manage it
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None:
            return None
        
        def approach1(headA, headB):
            sset = {-1}            
            
            while headA != None or headB != None:
                if headA in sset:
                    return headA
                elif headA != None:
                    sset.add(headA)
                    headA = headA.next
                
                if headB in sset:
                    return headB
                elif headB != None:
                    sset.add(headB)
                    headB = headB.next
                
                
            return None
        
        def approach2(headA, headB):
            cntA = 0
            tmp1 = headA
            tmp2 = headB
            while tmp1 != None:
                cntA += 1
                tmp1 = tmp1.next
                
            cntB = 0
            while tmp2 != None:
                cntB += 1
                tmp2 = tmp2.next
            
            diff = abs(cntA-cntB)
            
            if cntA > cntB:
                tmp1 = headA
                tmp2 = headB
            else:
                tmp1 = headB
                tmp2 = headA
            
            while diff > 0:
                tmp1 = tmp1.next
                diff -=1
            
            
            while tmp1 != None or tmp2 != None:
                if tmp1 == tmp2:
                    return tmp1
                else:
                    tmp1 = tmp1.next
                    tmp2 = tmp2.next
            
            return None
        
        # return approach2(headA, headB)
        return approach1(headA, headB)
    
