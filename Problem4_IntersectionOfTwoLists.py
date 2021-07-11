# Time Complexity: O(m + n), where m is length of listA and n is length of listB
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes

# Solution:

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if not headA or not headB:
            return None

        # Find the length of lists A and B
        lenA = lenB = 0
        curr = headA
        while curr:
            lenA += 1
            curr = curr.next

        curr = headB
        while curr:
            lenB += 1
            curr = curr.next

        # Move the pointer of list A or B such that lenA equals lenB
        while lenA > lenB:
            headA = headA.next
            lenA -= 1

        while lenB > lenA:
            headB = headB.next
            lenB -= 1

        # Move both list pointers simultaneously until the intersection node is reached
        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA










