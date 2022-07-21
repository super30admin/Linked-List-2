# Time Complexity = O(m + n), where m is the lenA, n is lenB
# Space Complexity = O(1)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None or headB == None:
            return None
        
        lenA = 0
        lenB = 0
        
        # Counting the length of A
        curr = headA
        while(curr != None):
            curr = curr.next
            lenA += 1
        
        # Counting the length of B
        curr = headB
        while(curr != None):
            curr = curr.next
            lenB += 1
            
        # If lenA is larger, move its pointer to the point both lengths are equal
        while(lenA > lenB):
            headA = headA.next
            lenA -= 1
            
        # If lenB is larger, move its pointer to the point both lengths are equal    
        while(lenB > lenA):
            headB = headB.next
            lenB -= 1
        
        # Until both pointers are equal/they meet
        while(headA != headB):
            headA = headA.next
            headB = headB.next
            
        return headA
            
            