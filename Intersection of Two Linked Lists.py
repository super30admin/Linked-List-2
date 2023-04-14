# Time Complexity :  O(l1+l2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1 = headA
        l2 = headB
        #using hashset
        # m = {}
        # while l1 != None or l2 != None:
        #     if l1 is not None:
        #         if l1 in m:
        #             return l1
        #         else:
        #             m[l1] = 0
        #         l1 = l1.next
        #     if l2 is not None:
        #         if l2 in m:
        #             return l2
        #         else:
        #             m[l2] = 0
        #         l2 = l2.next

        # return None
            
        #without using hashset

        l1c = l2c = 0

        while l1 != None:
            l1 = l1.next
            l1c += 1
        while(l2 != None):
            l2 = l2.next
            l2c += 1
        
        l1 = headA
        while(l1c > l2c):
            l1 = l1.next
            l1c -= 1

        l2 = headB
        while(l2c > l1c):
            l2 = l2.next
            l2c -= 1
        
        while(l1 != l2):
            l1 = l1.next
            l2 = l2.next
        return l1