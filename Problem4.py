# Did it run on Leetcode:Yes
# Time Complexity:O(m+n) we need to iterate through both the lists
# Space Complexity:O(1) constant space for extra pointers and length
# Approach find the length of the two linkedlist. The one which is bigger needs to be ahead of smaller by the difference to find the intersection. So once the differnece is found the one which is bigger is moved that many nodes ahead. Then we start iterating both the lists until same node is found. We return this node
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        a = 0
        b = 0
        currA = headA
        currB = headB
        while currA is not None:
            currA = currA.next
            a += 1
        while currB is not None:
            currB = currB.next
            b += 1

        currA = headA
        currB = headB

        if (a > b):
            for i in range(a - b):
                currA = currA.next
        elif (b > a):
            for i in range(b - a):
                currB = currB.next
        while currA is not None:
            if currA == currB:
                return currA
            currA = currA.next
            currB = currB.next

        return None




