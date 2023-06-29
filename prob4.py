# Time Complexity :O(m+n)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:

        currA, currB = headA, headB

        while currA != currB:
          currA = currA.next if currA else headB
          currB = currB.next if currB else headA
        return currA