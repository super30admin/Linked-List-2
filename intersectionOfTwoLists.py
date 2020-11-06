#Time Complexity : O(max(n,m)) where m and n are the number of elements in the linkedlists
#Space Complexity : O(1)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Find length of both lists, the whichever list is longer, start iterating from there till the difference of the lengths of the two linkedlist. This will bring both pointers to the same distance from the intersecting node. Then start iterating both linkedlists and where they meet is where they intersect. 

#Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        l1, l2 = 0,0
        h1, h2 = headA, headB

        while h1:
            l1 += 1
            h1 = h1.next

        while h2:
            l2 += 1
            h2 = h2.next

        hA, hB = headA, headB
        if l1 > l2:
            for _ in range(l1-l2):
                hA = hA.next

        if l2 > l1:
            for _ in range(l2-l1):
                hB = hB.next

        while hA != hB:
            hA = hA.next
            hB = hB.next

        return hA
