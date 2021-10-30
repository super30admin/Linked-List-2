# TC-O(n)
# SC-O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        p1 = headA
        p2 = headB
        len1 = 0
        len2 = 0
        while (p1 != None):
            len1 += 1
            p1 = p1.next
        while (p2 != None):
            len2 += 1
            p2 = p2.next
        # print(len1)
        # print(len2)
        p1 = headA
        p2 = headB
        if len1 > len2:
            for i in range(len1 - len2):
                p1 = p1.next
        else:
            for i in range(len2 - len1):
                p2 = p2.next
        # print(p1)
        # print(p2)
        while (p1 != p2):
            p1 = p1.next
            p2 = p2.next
        return p1