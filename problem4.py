"""
Time Complexity  : O(m+n) where m is the lenght of first LL nad n is the length of second LL
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Find the length of both the list.
Take the two pointers and place them at the beginning of both the list respectively. Iterate the pointer on the Linked List whose length is greater until length of both the linked list becomes equal. This will make both the pointers equidistant from the intersection.
Then move both the pointers until both the pointers coincides. 
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        
        ptr1 = headA
        ptr2 = headB
        
        #Find the length of first LL
        while headA != None:
            lenA += 1
            headA = headA.next
        
        #Find the length of second LL
        while headB != None:
            lenB += 1
            headB = headB.next
            
        while(lenA > lenB):
            ptr1 = ptr1.next
            lenA -= 1
        
        while(lenB > lenA ):
            ptr2 = ptr2.next
            lenB -= 1
        
        while(ptr1 != ptr2):
            ptr1 = ptr1.next
            ptr2 = ptr2.next
        
        return ptr1