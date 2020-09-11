# Time Complexity : O(m+n) m for first ptr, n for second
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach class Solution(object):


class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        #Maintain 2 ptrs and traverse them till end. If one reaches end then change the head to maintain the difference in size
        #Similarly if the other reach the end, change the head so that they should meet at some common node.
        p1 = headA
        p2 = headB
        
        while p1 != p2:
            if p1 != None:
                p1 = p1.next
            elif p1 == None:
                p1 = headB
            if p2 != None:
                p2 = p2.next
            elif p2 == None:
                p2 = headA
        return p1
        