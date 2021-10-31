#Time complexity O(n) space O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
    # Finding the lengths of two lists   
        l1=0
        l2=0
        cur=headA
        
        while cur:
            cur=cur.next
            l1+=1
            
        cur=headB   
        while cur:
            cur=cur.next
            l2+=1
 #comparing the lengths and traversing until it both the lengths are equal           
        while l2>l1:
            headB=headB.next
            l2-=1
            
        while l1>l2:
            headA=headA.next
            l1-=1
#trversing until we find the node that intersects            
        while headA!=headB:
            headA=headA.next
            headB=headB.next
                        
        return headA
