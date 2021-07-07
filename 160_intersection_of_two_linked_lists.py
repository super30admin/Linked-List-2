# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        """
            https://leetcode.com/problems/intersection-of-two-linked-lists/
            // Time Complexity : O(n)
            // Space Complexity : O(1)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                - Find the length of both the linked lists
                - Take the difference
                - Move both list pointer one at a time
        """
        length_A = length_B = 0
        tmpA = headA
        tmpB = headB
        while tmpA:
            tmpA = tmpA.next
            length_A += 1

        while tmpB:
            tmpB = tmpB.next
            length_B += 1

        if length_A > length_B:
            diff = length_A - length_B
            while diff > 0:
                headA = headA.next
                diff -= 1
        else:
            diff = length_B - length_A
            while diff > 0:
                headB = headB.next
                diff -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA

    def getIntersectionNode2(self, headA: ListNode, headB: ListNode) -> ListNode:
        # edge case
        if not headA or not headB:
            return None

        slow = fast = headB
        # pointer to form the cycle
        last = fast

        while last and last.next:
            last = last.next

        last.next = headA

        flag = False
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                flag = True
                break

        slow = None
        if flag:
            slow = headB
            while slow != fast:
                slow = slow.next
                fast = fast.next

        last.next = None
        return slow

        # a = headA
        # b = headB
        # while a is not b:
        #     a = headB if not a else a.next
        #     b = headA if not b else b.next
        # return a
