
"""
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 

Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
"""

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
    """
    Find the length of each list and substract the difference and move the highest length list forward with the difference and now move both pointers forward to find meeting point
    """
        # Run Time Complexity: O(N)
		# Space Complexity: O(1)
        def get(node):
            count = 0
            while node:
                count += 1
                node = node.next
            return count
        lena = get(headA)
        lenb = get(headB)
        if lena > lenb:
            for i in range(lena - lenb):
                headA = headA.next
        if lenb > lena:
            for i in range(lenb - lena):
                headB = headB.next
        while headA != headB:
            headA , headB = headA.next, headB.next
        return headA
        