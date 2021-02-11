#Time Complexity :O(1)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def deleteNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        head.val=head.next.val
        head.next=head.next.next