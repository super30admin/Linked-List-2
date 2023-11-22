# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def skipHead(self, head, length):
        while length:
            head = head.next
            length -= 1
        return head

    def getIntersectionNode(self, headA, headB):
        len_A, len_B = 0, 0

        temp = headA
        while temp:
            temp = temp.next
            len_A += 1

        temp = headB
        while temp:
            temp = temp.next
            len_B += 1

        if len_A > len_B:
            headA = self.skipHead(headA, len_A - len_B)
        elif len_B > len_A:
            headB = self.skipHead(headB, len_B - len_A)

        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

        return None
