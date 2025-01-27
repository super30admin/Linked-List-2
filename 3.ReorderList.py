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
        
        """
        Time Complexity: 0(n)
        Space Complexity: 0(1)
        Approach:
            Step 1 -- split the linked-list into 2 halves
            Step 2 -- we have 2 ptrs (head and headB), reverse the headB linked-list
            Step 3 -- update the linked list
        """

        # Step 1 -- split the linked-list into 2 halves
        fastPtr = head # moves by 2x speed
        slowPtr = head # moves by 1x speed

        while fastPtr.next != None and fastPtr.next.next != None:
            # fastPtr by 2x speed
            fastPtr = fastPtr.next.next
            slowPtr = slowPtr.next
        
        # slowPtr will be at optimal position for break
        headB = slowPtr.next

        # update the ptrs
        slowPtr.next = None
        slowPtr = None
        fastPtr = None

        # Step 2 -- we have 2 ptrs (head and headB)
        # reverse the headB linked-list

        prev = None
        temp = None

        while headB != None:
            prev = headB
            headB = headB.next
            prev.next = temp
            temp = prev
        
        # update the headB
        headB = prev
        prev = None
        temp = None

        # Step 3 -- update the linked list
        headA = head
        prevA = None
        prevB = None

        while headB != None:
            prevA = headA
            headA = headA.next
            prevA.next = headB

            prevB = headB
            headB = headB.next
            prevB.next = headA
        
        # avoid dangling ptrs
        headA = None
        headB = None
        prevA = None
        prevB = None

        return head