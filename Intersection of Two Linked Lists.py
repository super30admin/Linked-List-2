# Time complexity : O(n)
# Space complexity : O(1)

# The code ran on Leetcode

# Store nodes from first list in a hash map. Iterate over secong linked list and return the element that matches with the hashmap

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        nodes = set()
        while headA:
            nodes.add(headA)
            headA = headA.next

        while headB:
            if headB in nodes:
                return headB

            headB = headB.next
        return None
