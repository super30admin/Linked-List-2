# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    #Solution 1
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        #Approach: Skip nodes
        #Time Complexity: O(m + n)
        #Space Complexity: O(1)
        
        lenA = 0
        curr = headA
        while curr:
            curr = curr.next
            lenA += 1
        
        lenB = 0
        curr = headB
        while curr:
            curr = curr.next
            lenB += 1
            
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
            
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
            
        while headA != headB:       #also takes care of the 'no intersection' scenario
            headA = headA.next
            headB = headB.next
            
        return headA                #or headB
    
    #Solution 2:
    """
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        #Approach: Two pointers
        #Time Complexity: O(m + n)
        #Space Complexity: O(1)
        
        if not headA or not headB:
            return None
        
        pointer1 = headA
        pointer2 = headB
        
        while pointer1 != pointer2:
            print(pointer1.val)
            pointer1 = pointer1.next
            pointer2 = pointer2.next
            
            if not pointer1 and not pointer2:       #no intersection
                continue
            if not pointer1:
                pointer1 = headB
            if not pointer2:
                pointer2 = headA
        
        return pointer1
    """