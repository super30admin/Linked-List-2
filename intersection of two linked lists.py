#tc: O(m + n)
#sc: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA and headB is None: #base case
            return None

        lenA = 0 #initializing 
        lenB = 0
        curr = headA
        while curr is not None: #calculating length A
            curr = curr.next
            lenA += 1

        curr = headB #using the same pointer to calculate length B
        while curr is not None:
            curr = curr.next
            lenB += 1
        
        while lenA > lenB: #if the upper list is long
            headA = headA.next
            lenA -= 1

        while lenB > lenA: #if the below list is long
            headB = headB.next
            lenB -= 1

        while headA != headB: #till both the nodes intersect
            headA = headA.next
            headB = headB.next
        
        return headA
        

        
        
