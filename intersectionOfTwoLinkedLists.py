# Time Complexity : O(2n), where n is the number of nodes in the linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# Use 2 pointers starting at the heads of both linked lists.
# Make both the pointers traverse equal lengths.
# If they traverse the same length, they will meet at the intersection point.
# If they do not meet, they will both reach the end of the lists at the same time.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode):
        # Initialize two pointers a and b to the heads of the two linked lists
        a, b = headA, headB
        # Traverse both linked lists until both pointers intersect
        # If one pointer reaches the end, switch it to the head of the other linked list
        # This way, both pointers will traverse the same length
        while a or b:
            if not a:
                a = headB
            if not b:
                b = headA
            if a == b:
                return a
            a = a.next
            b = b.next
            

# Time Complexity : O(2n), where n is the number of nodes in the linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Alternative approach using length of linked lists
# This approach uses the lengths of the linked lists to traverse them equally
# Starting from the heads of both linked lists, we first calculate their lengths.
# Then we move the pointer of the longer linked list forward by the difference in lengths.
# After that, we traverse both linked lists simultaneously until we find the intersection point.

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode):
        # Initialize two pointers a and b to the heads of the two linked lists
        a, b = headA, headB
        # Initialize two counters to count the number of nodes in each linked list
        countA, countB = 0, 0

        # Traverse both linked lists to count the number of nodes in each linked list
        while a:
            countA += 1
            a = a.next
        while b:
            countB += 1
            b = b.next
        # Reset the pointers to the heads of the linked lists
        a, b = headA, headB
        # Move the pointer of the longer linked list forward by the difference in lengths
        # This way, both pointers will traverse the same length
        while countA > countB:
            a = a.next
            countA -= 1
        while countB > countA:
            b = b.next
            countB -= 1
        
        # Traverse both linked lists simultaneously until we find the intersection point
        while a:
            if a == b:
                return a
            a = a.next
            b = b.next