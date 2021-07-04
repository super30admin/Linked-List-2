# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lenA = 0
        LenB = 0
        curr = headA
        #get length from A
        while curr:
            curr = curr.next
            lenA+=1
        curr = headB
        #get length for B
        while curr:
            curr = curr.next
            LenB +=1
        #make the two pointers at the same length from end
        while lenA> LenB:
            headA = headA.next
            lenA-=1
        while LenB> lenA:
            headB = headB.next
            LenB-=1
        #move until reach theinterserction or None
        while headA != headB:
            headA = headA.next
            headB = headB.next
        return headA