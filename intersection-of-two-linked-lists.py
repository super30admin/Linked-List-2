# Time Complexity: O(m+n)
# Space Complexity: O(1)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # Brute Force
        # Time Complexity: O(mn)
        # Space Complexity: O(1)
        while headA is not None:
            ptr = headB
            while ptr is not None:
                if headA == ptr:
                    return headA
                ptr = ptr.next
            headA = headA.next
        return 
            
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # Two pointers Approach
        lenA = 0
        lenB = 0
        
        # Take a temp value so that the value of head is not changed
        temp = headA
        
        # Calculate the length of linked list A
        while temp:
            lenA += 1
            temp = temp.next
        
       # Take a temp value so that the value of head is not changed
        temp = headB
        
        # Calculate the length of linked list B
        while temp:
            lenB += 1
            temp = temp.next

        # If length of A is bigger, increment the pointer at head of A till they become of the same length
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        
        # If length of B is bigger, increment the pointer at head of B till they become of the same length
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        
        # When they are not the same, move both the pointer till both meet
        while headA is not headB:
            headA = headA.next
            headB = headB.next
        
        return headA
        