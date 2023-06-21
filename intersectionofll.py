# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        first_set=set()
        curr=headA
        
        while curr:
            first_set.add(curr)
            curr=curr.next
        
        curr = headB
        while curr:
            if curr in first_set:
                return curr
            curr=curr.next

        return None