# Time Complexity: O(N)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Here we get the length of both lists using slow and fast pointer
# then we move the longer one by their difference(lenA-lenB) and then increment both together
# so if there is an intersection they would point to the same node
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        first = self.getL(headA)
        sec = self.getL(headB)
        diff = abs(sec-first)

        if first>sec:
            for _ in range(diff):
                headA=headA.next
        elif sec>first:
            for _ in range(diff):
                headB=headB.next

        while headA and headB:
            if headA==headB:
                return headA
            headA = headA.next
            headB = headB.next
        return None


    def getL(self,head):
        slow = head
        fast = head
        length = 1
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            length+=2

        if fast==None:
            length-=1
        return length