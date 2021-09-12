# Did this code successfully run on Leetcode : YES

# TC: O(M+N)
# SC: O(M)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        hashset = set()
        while headA:
            hashset.add(headA)
            headA = headA.next
        while headB:
            if headB in hashset:
                return headB
            headB = headB.next
        return None

# Did this code successfully run on Leetcode : YES

# TC: O(M+N)
# SC: O(1)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # hashset = set()
        # while headA:
        #     hashset.add(headA)
        #     headA = headA.next
        # while headB:
        #     if headB in hashset:
        #         return headB
        #     headB = headB.next
        # return None
        lenA = 0
        curr = headA
        while curr:
            lenA += 1
            curr = curr.next
        lenB = 0
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