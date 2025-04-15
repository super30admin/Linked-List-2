# This solution finds the intersection node of two singly linked lists by first calculating their lengths.
# It then aligns both pointers by advancing the longer list’s pointer by the length difference.
# Finally, it moves both pointers one step at a time until they meet at the intersection or reach the end.

# Time Complexity: O(m + n), where m and n are the lengths of the two linked lists.
# Space Complexity: O(1), as only a constant amount of space is used.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        lenA, lenB = 0, 0
        currA, currB = headA, headB

        # Calculate lengths of both linked lists
        while currA:
            lenA += 1
            currA = currA.next
        
        while currB:
            lenB += 1
            currB = currB.next

        # Reset pointers to the start of each linked list
        currA, currB = headA, headB

        # Advance the pointer for the longer list by the difference in lengths
        diff = abs(lenA - lenB)

        if lenA > lenB:
            while diff:
                currA = currA.next
                diff -= 1
        else:
            while diff:
                currB = currB.next
                diff -= 1

        # Move both pointers until they find the intersection or reach the end
        while currA != currB:
            currA = currA.next
            currB = currB.next

        return currA
