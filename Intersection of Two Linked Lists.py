# Time Complexity : O(n) where n is the maximum element in a list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# we will find the list which is bigger and get the difference between both the list
# we traverse the bigger list upto the difference we found above
# from there we will iterate both the list together and the node where they meet each other is the midpoint

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:

        countA = 0
        currA = headA

        while currA is not None:
            currA = currA.next
            countA += 1

        countB = 0
        currB = headB
        while currB is not None:
            currB = currB.next
            countB += 1

        while countA > countB:
            headA = headA.next
            countA -= 1

        while countB > countA:
            headB = headB.next
            countB -= 1

        while headA != headB:
            headA = headA.next
            headB = headB.next

        return headA







