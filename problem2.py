'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation : Find the midpoint of the list, reverse the second half of the rest and then join the alternate nodes in the
2 lists.
'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverse(self, head: ListNode) -> ListNode:
        R = None
        cursor = head
        while cursor != None:
            next1 = cursor.next
            cursor.next = R
            R = cursor
            cursor = next1
        return R

    def mid(self, head: ListNode) -> ListNode:
        fast = head
        slow = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        return slow

    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # base case
        if head == None:
            return None

        # find middle of linkedlist
        mid = self.mid(head)

        # reverse
        reverse = self.reverse(mid.next)

        mid.next = None  # as the mid is dangling and breaking the list into 2 parts
        # one for the first half and one for the reversed second half

        # zip
        cursorA = head
        cursorB = reverse

        # B is greater as it the end of the list
        while cursorB != None:
            nextA = cursorA.next
            nextB = cursorB.next

            cursorA.next = cursorB
            cursorB.next = nextA

            cursorA = nextA
            cursorB = nextB

