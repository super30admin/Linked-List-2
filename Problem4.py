## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA == None:
            return None
        curr = ListNode()
        curr = headA
        lenA = 1
        while(curr!=None):
            lenA = lenA+1
            curr = curr.next 
        curr = headB
        lenB=1
        while curr!=None:
            lenB = lenB+1
            curr = curr.next
        while lenA>lenB:
            headA=headA.next
            lenA = lenA-1
        while lenB>lenA:
            headB=headB.next
            lenB = lenB-1
        while headA != headB:
            headA=headA.next
            headB=headB.next
        return headA
        #Time complexity: O(n) n = total number nodes present in both the lists
        #Space Complexity: O(1)
        #Approach - two pointers starting at the start of the lists, find the length of each list, move the header of the longest list untill both the pointers are at the same number of node, once thatpoint is reached check for value and if similar then return that node value. 
                
            
           
        
            