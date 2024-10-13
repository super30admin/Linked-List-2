#Approach
# To get the intersection bot the length of the list need to be calculated as we need to have the comparing two lists
# the travesing the pointer to same length if one of them is greater and check untill the both lists points to same node




# Complexities
#Time Complexity: O(n)
# Space Complexity: O(1)


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
from typing import Optional


class Solution:
    def getLengthLinkedList(self, head):
        length = 0
        temp = head
        while temp != None:
            temp = temp.next
            length += 1

        return length

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = self.getLengthLinkedList(headA)
        lenB = self.getLengthLinkedList(headB)
        currA = headA
        currB = headB
        if lenA > lenB:
            count = 0
            while count != (lenA - lenB):
                currA = currA.next
                count += 1
        elif lenA < lenB:
            count = 0
            while count != (lenB - lenA):
                currB = currB.next
                count += 1
        while currA != None and currB != None:
            if currA == currB:
                return currA
            currA = currA.next
            currB = currB.next
        return None

