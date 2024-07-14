#// Time Complexity : O(n) 
# // Space Complexity : O(1)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no i saw the class and then did the problem

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        count = 0
        count1 =  0
        p1 = headA
        p2= headB
        while p1:
            count+=1
            p1 = p1.next
        
        while p2:
            count1 += 1
            p2 = p2.next
        
        p1= headA
        p2= headB
        while count > count1:
            count -= 1
            p1=p1.next
        
        while count1 > count:
            count1 -= 1
            p2 = p2.next

        while p1 != p2:
            p1 = p1.next
            p2 = p2.next
        
        return p1

# Approach:
# 1. Find the length of both the lists
# 2. Traverse the lists till the length of the shorter list
# 3. Now traverse both the lists simultaneously and return the node where they meet