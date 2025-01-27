# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:

    """
    Time Complexity : 0(n+m) + 0(n)
    Space Complexity: 0(1)
    Approach: 
        1. Cal the distance for headA and headB linked-list
        2. Find the difference
        3. Which-ever linked-list is greater, move head ptr by difference position so that both head of linked
        list point at same index position
        4. Move both ptr and check if we have a match for intersection 
    """

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        # get the lenght of listA and listB
        distA = 0
        distB = 0

        ptrA = headA
        while ptrA != None:
            distA += 1
            ptrA = ptrA.next
        

        ptrB = headB
        while ptrB != None:
            distB += 1
            ptrB = ptrB.next

        # reset the ptrs
        ptrA = headA
        ptrB = headB

        # calculate the difference
        diff = abs(distA - distB)
        
        if distA > distB:
            while diff != 0:
                diff -= 1
                ptrA = ptrA.next
        elif distA < distB:
            while diff != 0:
                diff -= 1
                ptrB = ptrB.next
        
        # move ptrA and ptrB together
        result = None
        while ptrA != None and ptrB != None:
            if ptrA == ptrB:
                result = ptrA
                break
            else:
                ptrA = ptrA.next
                ptrB = ptrB.next
        
        return result


        