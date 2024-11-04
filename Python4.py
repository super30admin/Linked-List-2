# Time Complexity : O(m + n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Intersection of Two Linked Lists

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None

        currA, currB = headA, headB

        while currA != currB:
            currA = currA.next if currA else headB
            currB = currB.next if currB else headA

        return currA
        
        # ----------  -----------
        # currA = headA
        # currB = headB
        # countA = 0
        # countB = 0

        # while currA != None:
        #     currA = currA.next
        #     countA += 1
        
        # while currB != None:
        #     currB = currB.next
        #     countB += 1

        # currA = headA
        # currB = headB

        # while countA > countB:
        #     currA = currA.next
        #     countA -= 1
            
        # while countB > countA:
        #     currB = currB.next
        #     countB -= 1
            
        # while currA != currB:
        #     currA = currA.next
        #     currB = currB.next

        # return currA
