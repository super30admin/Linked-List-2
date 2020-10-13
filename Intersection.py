// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        current_1 = headA
        current_2 = headB
        d = dict()
        
        while current_1:
            d[current_1] = d.get(current_1, 0) + 1
            current_1 = current_1.next
        
        while current_2:
            if current_2 in d:
                return current_2
            current_2 = current_2.next
        
        return None