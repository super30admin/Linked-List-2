# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  We get the lengths of the 2 lists and then move ahead in the longer list by the larger length. 
# Now if we move the pointers together, we will end up on the intersecting node together.
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1, l2 = 0, 0
        currA, currB = headA, headB
        
        while currA:
            l1 += 1
            currA = currA.next

        while currB:
            l2 += 1
            currB = currB.next

        if l2 > l1:
            headA, headB = headB, headA

        currA, currB = headA, headB
        
        for _ in range(abs(l2-l1)):
            currA = currA.next

        while currA != currB:
            currA = currA.next
            currB = currB.next
        return currA