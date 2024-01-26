# Approach 1 - Put first linked list in hashset. Then traverse through the second linked list. Check if particular node is present in the hashset. If yes, we found intersection. 
# TC - O(m+n), SC - O(m+n)
# Approach 2 - Calculate the length and then difference 'n' between both linked list. Traverse the head of bigger linked list by  n times. Now intersection is equidistant from both heads. Return the node if both head are equal or else None.
# TC - O(m+n), SC - O(1) 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 1
        lenB = 1
        currA = headA
        currB = headB
        while currA.next:
            lenA += 1
            currA = currA.next
        while currB.next:
            lenB += 1
            currB = currB.next
        n = abs(lenB - lenA)
        
        for i in range(0,n):
            if lenB > lenA:
                headB = headB.next
            else:
                headA = headA.next
        m = max(lenA, lenB) - n

        for i in range(0,m):
            if headA == headB:
                return headA
            else:
                headA = headA.next
                headB = headB.next
        return None
        

        
        