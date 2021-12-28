# Time Complexity : O(m+n)
# Space Complexity : 0(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None :
            return None
        lenA =0
        curr = headA
        while curr!=None:
            curr=curr.next
            lenA+=1
        lenB =0
        curr = headB
        while curr!=None:
            curr=curr.next
            lenB+=1
        while lenA >lenB:
            headA = headA.next
            lenA-=1
        while lenB>lenA:
            headB= headB.next
            lenB-=1
        while headA != headB:
            headA=headA.next
            headB= headB.next
        return headA
        
        