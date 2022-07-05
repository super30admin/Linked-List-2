#160. Intersection of Two Linked Lists
"""
// Time Complexity : O(m+n) m = length of LL1 and n = lenght of LL2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
pointer p1 at head of LL1
pointer p2 at head of LL2
Find lenght of both. l1 and l2
if l1>l2, then increase p1 till l1-l2. then iterate p1 nad p2 at 1x. They will meet at intersection.
Vice-versa if l2>l1

"""
#160. Intersection of Two Linked Lists
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        #null case
        
        #logic
        
        #calculating lenght of LL1
        p1 = ListNode()
        p1 = headA
        l1 = 0 #lenght of LL1
        while (p1 != None):
            p1 = p1.next
            l1 = l1 + 1
        p1 = headA
        print("l1 = ", l1)
        
        #calculating lenght of LL2
        p2 = ListNode()
        p2 = headB
        l2 = 0 #lenght of LL2
        while (p2 != None):
            p2 = p2.next
            l2 = l2 + 1
        p2 = headB
        print("l2 = ", l2)
        
        #p1 and p2 at same location in respecetive LL
        count = 0
        if l1 > l2:
            while count != (l1-l2):
                p1 = p1.next
                count += 1
        else:
            while count != (l2-l1):
                p2 = p2.next
                count += 1
                
        #p1 and p2 at 1x. They will meet at intersection
        while p1 != p2:
            p1 = p1.next
            p2 = p2.next
        
        return p1
