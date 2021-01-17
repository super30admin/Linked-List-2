'''
    Time Complexity:
        O(n)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Not on LeetCode.

    Problems faced while coding this:
        None

    Approach:
        Find the length of the lists and the last node of the lists.
        If the last of the two aren't equal, there's no intersection.
        Skip the longer list until the two heads align.
        Move the two heads until they are equal.
        Return any of the heads.
'''
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None

        lenA, lastA = self.get_len_and_last(headA)
        lenB, lastB = self.get_len_and_last(headB)

        if lastA != lastB:
            return None

        skip = abs(lenA - lenB)

        while skip != 0:
            if lenA > lenB:
                headA = headA.next
            else:
                headB = headB.next
            skip -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA

    def get_len_and_last(self, head):
        len = 1

        while head.next:
            head = head.next
            len += 1

        return len, head
