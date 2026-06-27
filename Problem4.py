## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
# Time Complexity: $O(M + N)$, where M and N are the lengths of headA and headB respectively. 
# We traverse each list to find their lengths, and then traverse them again to find the intersection.
# Space Complexity: $O(1)$, because we only use a constant amount of extra memory for pointers and length variables.

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Step 1: Calculate the length of the first linked list (headA)
        lenA = 0
        current = headA
        while current:
            current = current.next
            lenA += 1
            
        # Step 2: Calculate the length of the second linked list (headB)
        lenB = 0
        current = headB
        while current:
            current = current.next
            lenB += 1
            
        # Step 3: Align the starting pointers.
        # If one list is longer than the other, we advance the pointer of the longer list 
        # by the difference in their lengths. This ensures both pointers are now exactly 
        # the same distance away from the end of their respective lists.
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
            
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
            
        # Step 4: Traverse both lists simultaneously.
        # Since they are aligned, if they intersect, the pointers will meet at the exact same node.
        # If they don't intersect, both pointers will eventually reach the end (None) at the same time.
        while headA != headB:
            headA = headA.next
            headB = headB.next
            
        # Return the intersection node, or None if there is no intersection
        return headA