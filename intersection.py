# Time Complexity : O(m+n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        curr,lenA = headA,0
        while curr is not None:
            curr=curr.next
            lenA+=1
        curr,lenB = headB,0
        while curr is not None:
            curr=curr.next
            lenB+=1
        if lenA > lenB:
            while lenA > lenB:
                headA= headA.next
                lenA-=1
        elif lenB > lenA:
            while lenB > lenA:
                headB = headB.next
                lenB-=1
        while headA != headB:
            headA= headA.next
            headB = headB.next
        return headA
