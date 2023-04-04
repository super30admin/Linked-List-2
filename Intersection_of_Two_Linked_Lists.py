# Time Complexity : O(M + N) where M and N are the lengths of list1 and list2
# Space Complexity : O(1)

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        lenA = self.getListLength(headA)
        lenB = self.getListLength(headB)
        
        # move the longer list head to the same distance from the end as the length of the shorter list
        if lenA > lenB:
            for i in range(lenA - lenB):
                headA = headA.next
        elif lenB > lenA:
            for i in range(lenB - lenA):
                headB = headB.next
        
        # traverse both lists to find the intersection node
        while headA != headB:
            headA = headA.next
            headB = headB.next
        
        return headA
        
    def getListLength(self, head: ListNode) -> int:
        length = 0
        while head:
            length += 1
            head = head.next
        return length
