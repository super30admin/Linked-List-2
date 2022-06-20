# Time Complexity : O(m+n)
# Space Complexity : O(1);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode):
        countA = 0
        countB = 0
        tempA = headA
        tempB = headB
        while tempA:
            countA += 1
            tempA = tempA.next
        while tempB:
            countB += 1
            tempB = tempB.next
        tempc = 0
        while tempc != abs(countA-countB):
            if max(countA, countB) == countA:
                headA = headA.next
                tempc += 1
            if max(countA, countB) == countB:
                headB = headB.next
                tempc += 1
        while headA and headB:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

    def printList(self):
        temp = self.getIntersectionNode(check, check1)
        if temp:
            print('Intersected at', temp.val)
        else:
            print('No Intersection')


check = ListNode(1)
check.next = ListNode(9)
check.next.next = ListNode(1)
check.next.next.next = ListNode(2)
check.next.next.next.next = ListNode(4)
check1 = ListNode(3)
check1.next = check.next.next.next
check1.next.next = ListNode(4)
Solution().printList()

# class Solution:
#     def __init__(self):
#         self.set = set()

#     def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
#         while headA:
#             self.set.add(headA)
#             headA = headA.next
#         while headB:
#             if headB in self.set:
#                 return headB
#             headB = headB.next
#
#     def printList(self):
#         temp = self.getIntersectionNode(check, check1)
#         if temp:
#             print('Intersected at', temp.val)
#         else:
#             print('No Intersection')
#
#
# check = ListNode(1)
# check.next = ListNode(9)
# check.next.next = ListNode(1)
# check.next.next.next = ListNode(2)
# check.next.next.next.next = ListNode(4)
# check1 = ListNode(3)
# check1.next = check.next.next.next
# check1.next.next = ListNode(4)
# Solution().printList()
