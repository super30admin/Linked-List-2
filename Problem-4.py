class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:

        pa=headA
        pb=headB

        while (pa != pb):
            pa = pa.next if pa!=None else headB
            pb = pb.next if pb!=None else headA

        return pa
