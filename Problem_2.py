"""
## Problem2 (https://leetcode.com/problems/reorder-list/)
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        TC: O(n) ; SC: O(1)
        """
        if head is None or head.next is None: return

        # call the middle node
        middleNode = self.findMiddle(head)
        secondHead = self.reverseList(middleNode.next)
        print("mid", middleNode)
        print("senH", secondHead)
        middleNode.next = None
        curr = head

        while secondHead:
             # TC: O(n) ; SC: O(1)
            f1, f2 = curr.next, secondHead.next
            curr.next, secondHead.next = secondHead, f1
            secondHead, curr = f2, f1


    def reverseList(self, head):
         # TC: O(n) ; SC: O(1)
        prev = None
        curr = head

        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        return prev


    def findMiddle(self, head):
        # TC: O(n) ; SC: O(1)
        slow = fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        return slow