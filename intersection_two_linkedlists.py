# Time Complexity : O(M * N) where M and N is number of nodes in the two linked lists respectively.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        curr = headA
        i = 1
        while curr.next is not None:
            curr = curr.next
            i += 1
            
        curr = headB
        j = 1
        while curr.next is not None:
            curr = curr.next
            j += 1
                        
        if i > j:
            diff = i - j
            currA = headA
            currB = headB
            while diff > 0:
                diff -= 1
                currA = currA.next
            
            while currB != currA and currA is not None and currB is not None:
                currA = currA.next
                currB = currB.next
                
            return currA
        else:
            diff = j - i
            currA = headA
            currB = headB
            while diff > 0:
                diff -= 1
                currB = currB.next
            
            while currB != currA and currA is not None and currB is not None:
                currA = currA.next
                currB = currB.next
                
            return currA