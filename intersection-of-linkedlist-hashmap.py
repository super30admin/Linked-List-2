# Time Complexity : O(n+m)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        set1=set()
        
        while headA!=None:

            set1.add(headA)
            headA=headA.next  

        while headB!=None:
            if headB in set1:
                return headB
            headB=headB.next
        
        return None