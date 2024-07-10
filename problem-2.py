# Time Complexity :
# worst case :O(n)
# space complexity : O(1)

# Approach :

#  find the middle node of the linkedlist
#  reverse the second half of the linked list
#  place a second pointer as the head of the reversed list
#  keep placing a link alternatvely between head and reversed head pointer

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None:
            return None

        getMidPointVal = self.getMidPoint(head)
        revListVal = self.revList(getMidPointVal)

        currPoint = head
        lastPoint = revListVal

        while currPoint is not None:

            tmp = currPoint.next
            currPoint.next = lastPoint
            currPoint = tmp

            tmp = lastPoint.next
            lastPoint.next = currPoint
            lastPoint = tmp

        return head

    def revList(self, head):

        currNode = head
        prevNode = None
        nextNode = None

        while (currNode is not None):

            nextNode = currNode.next
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode

        return prevNode

    def getMidPoint(self, head):

        a = head
        b = head

        while (b.next is not None and b.next.next is not None):
            a = a.next
            b = b.next.next

        return a
