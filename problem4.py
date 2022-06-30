# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lengthA = self.getLen(headA)
        lengthB = self.getLen(headB)
        
        diff = abs(lengthA-lengthB)
        
        first = headA if lengthA > lengthB else headB
        second = headA if first == headB else headB
        
        while diff > 0:
            diff -= 1
            first = first.next
        
        while first != second:
            first = first.next
            second = second.next
        
        return first
    
    def getLen(self,head):
        length = 0
        while head:
            length += 1
            head = head.next
        return length