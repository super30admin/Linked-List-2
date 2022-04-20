#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : yes

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None
        curA , curB = headA , headB
        while curA != curB:
            curA = curA.next if curA else headB
            curB = curB.next if curB else headA
        return curA