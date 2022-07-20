# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
# Time Complexity => O(N)
# Space Complexity => O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        while(headA is None or headB is None):
            return None
        lenA = 0
        lenB = 0
        ptr1 = headA
        ptr2 = headB
        while(ptr1 is not None):
            ptr1 = ptr1.next
            lenA+=1
        while(ptr2 is not None):
            ptr2 = ptr2.next
            lenB+=1
        while(lenA!=lenB):
            if(lenA>lenB):
                headA = headA.next
                lenA-=1
            else:
                headB = headB.next
                lenB-=1
        while(headA!=headB):
            headA = headA.next
            headB = headB.next
        return headA
        