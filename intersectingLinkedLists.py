# TC: O(m+n)
# SC: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        p1=headA
        p2=headB

        while p1!=p2:
            p1=p1.next if p1 else headB
            p2=p2.next if p2 else headA
        
        return p2