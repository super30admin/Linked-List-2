# Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
# Time Complexity: O(m +n), where m and n are the lengths of listA and listB. One full pass to count each list, then a bounded pass to align starting points, then a synchronized walk, all linear.
#Space Complexity: O(1),only a few pointer/counter variables used, no extra data structures regardless of list length.
# Approach: Find each list's length, advance the longer list's pointer to close the length gap, then walk both pointers together one step at a time. 
#Since they are now equidistant from the end,they will land on the same node together if the lists intersect, 
#or hit None together if they don't.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        countA = 0
        countB = 0

        currentA = headA
        currentB = headB

        # First full pass through list A just to count its total length
        while currentA:
            countA +=1
            currentA = currentA.next
        
        # Same thing for list B, get its total length into countB
        while currentB:
            countB +=1
            currentB = currentB.next
        
        # Reset both pointers back to their heads since the counting loops
        currentA = headA
        currentB = headB

        # If list A is longer, advance currentA to close the length gap
        while countA > countB:
            currentA = currentA.next
            countA -=1
        
        # If list B is longer, advance currentB to close the length gap
        # (only one of these two while loops actually runs, or neither)
        while countB > countA:
            currentB = currentB.next
            countB -=1
        
        # Both pointers are now equidistant from the end of their lists, so
        # walk them together one step at a time, they will meet at the same
        # node object if the lists intersect, or both become None together at the same time if they don't
        while currentA != currentB:
            currentA = currentA.next
            currentB = currentB.next
        
        return currentA