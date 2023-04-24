'''
Approach
--------
Using the hare and tortoise algo to find the interecting node by flipping the pointers once each of list is reached, 
they meet either at intersecting point or at null point which is end of list


Complexity Analysis
-------------------
TC = O(n+m) n is size of listA and m is size of listB
SC = O(1) not storing anything
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        a = headA
        b = headB
        
        while( a != b):
            if a == None:
                a = headB
            else:
                a = a.next
            if b == None:
                b = headA
            else:
                b = b.next
        
        return a