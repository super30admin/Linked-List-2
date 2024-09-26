#160. Intersection of Two Linked Lists
#Time Complexity : O(n) 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA = 0
        lenB = 0
        curr1 = ListNode()
        curr2 = ListNode()
        curr1 = headA
        curr2 = headB
        while curr1:
            curr1 = curr1.next
            lenA += 1
        while curr2:
            curr2 = curr2.next
            lenB += 1
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