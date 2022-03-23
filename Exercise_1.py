
    # 160. Intersection of Two Linked Lists
    # Time Complexity : O(N+M)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        lenA = 0
        lenB = 0
        curr = headA
        while (curr!=None):
            curr= curr.next
            lenA +=1
        
        curr = headB
        while (curr!=None):
            curr= curr.next
            lenB +=1
            
        while(lenA>lenB):
            headA = headA.next
            lenA-=1
            
        while(lenB>lenA):
            headB = headB.next
            lenB-=1
            
        while(headA != headB):
            headA = headA.next
            headB = headB.next
        return headA
            
            