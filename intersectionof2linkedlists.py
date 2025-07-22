# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Time Complexity: O(m+n) #length of two linked list
# Space Complexity: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None or headB is None:
            return None

        listA = headA
        listB = headB
        cntA = 0
        cntB = 0

        while listA:  # find length of headA
            cntA += 1
            listA = listA.next

        while listB:  # find length of listB
            cntB += 1
            listB = listB.next

        listA = headA
        while cntA > cntB:
            listA = listA.next
            cntA -= 1

        listB = headB
        while cntB > cntA:
            listB = listB.next
            cntB -= 1

        while listA != listB:
            listA = listA.next
            listB = listB.next

        return listA

        # dummy=ListNode(headA)
        # answer=dummy
        # res=set()

        # while headA:
        #     res.add(headA)
        #     headA=headA.next

        # while headB:
        #     if headB in res:
        #         return headB
        #     headB=headB.next

        # return None