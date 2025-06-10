#Time Complexity: O(m + n)
#Space Complexity: O(1)

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        p1 = headA
        p2 = headB

        while p1 != p2:
            if p1:
                p1 = p1.next
            else:    
                p1 = headB
            if p2:
                p2 = p2.next
            else:
                p2 = headA
            
        return p1


        