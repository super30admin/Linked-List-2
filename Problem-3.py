# Time Complexity :O(m+n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Calculate lengths of both linked lists and align the longer list to the same remaining length.
# Traverse both lists simultaneously until the nodes match.
# Return the intersection node, or null if no intersection exists.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0

        curr1 =  headA
        curr2 = headB
        while curr1:
            lenA += 1
            curr1 = curr1.next
        while curr2:
            lenB += 1
            curr2 = curr2.next

        while abs(lenA-lenB)>0:
            if lenA>lenB:
                headA = headA.next
                lenA -= 1
            else:
                headB = headB.next
                lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        if headA == None:
            return None
        return headA


        
        