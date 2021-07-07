#
# Time Complexity = O(n)
# Space Complexity = O(1)
#

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        node1, node2 = headA, headB
        temp1, temp2 = headA, headB

        while node1 and node2:
            node1 = node1.next
            node2 = node2.next

        if not node1:
            node1, node2 = node2, node1
            headA, headB = headB, headA

        while node1:
            temp1 = temp1.next
            node1 = node1.next

        while temp1 != temp2:
            temp1 = temp1.next
            temp2 = temp2.next

        return temp2
