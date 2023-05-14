# Linked-List-2

## Problem2 (https://leetcode.com/problems/reorder-list/)
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def reorderList(self, head):
        if not head or not head.next:
            return head
        # find mid
        slow = head
        fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # reverse second half
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head

        # merge
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        return head

    def reverse(self, head):
        prev = None
        curr = head
        fast = head.next
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr

## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA = 0
        lenB = 0

        curr = headA
        while curr:
            lenA += 1
            curr = curr.next

        curr = headB
        while curr:
            lenB += 1
            curr = curr.next

        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA

