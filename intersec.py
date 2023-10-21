# Time Complexity : O(m+n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# we find the lenght of each list. take the diff in length and start slow pointer from the start root node of smaller LL and 
# fast pointer from skipping the diff nodes from root of other LL - now increment slow and fast by one until both pointers point at same node
# at this node we have the intersection found
class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        count, lenA, lenB=0, 0, 0
        curr=headA
        while(curr!=None):
            curr=curr.next
            lenA+=1
        curr=headB
        while(curr!=None):
            curr=curr.next
            lenB+=1
        # print(headB)
        while(lenA>lenB):
            headA = headA.next
            lenA-=1
        # print(headB)
        while(lenA<lenB):
            headB = headB.next
            lenB-=1
        while(headA!=headB):
            headA=headA.next
            headB=headB.next
        return headA
        