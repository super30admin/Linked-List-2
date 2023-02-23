# Author: Naveen US
# Title: Intersection of Two Linked Lists

# Time complexity: O(n+m)
# Space complexity: O(n)
# Did the code run on leetcode: Yes
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
