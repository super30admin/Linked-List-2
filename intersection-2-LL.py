"""
Runtime Complexity:
O(n) - we calculate the length of both the linked list and we move the pointers of list which has the larger length until both the list is traversed to the element before the intersection element. We then again traverse, at one point, they both meet at the same element and this is our intersection element.
Space Complexity:
O(1) - no extra space/data structue was used to compute the solution.
Yes, the code worked on leetcode.
Issues while coding- No

"""

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA == None and headB == None:
            return None
        lenA, lenB = 0,0
        curr = headA
        while(curr!=None):
            curr = curr.next
            lenA+=1
        curr = headB
        while(curr!=None):
            curr = curr.next
            lenB+=1
        
        while(lenA>lenB):
            headA = headA.next
            lenA-=1
        
        while(lenB>lenA):
            headB = headB.next
            lenB-=1
        
        while(headA!=headB):
            headA = headA.next
            headB = headB.next
        
        return headA
        