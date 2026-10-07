# Time Complexity : O(M+N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# First is we get the length of both the lists to check which list has greater length
# Then we iterate over the list which has greater length until it is the same length as the second list
# Then we can start to iterate simultaneously over two lists until they meet to get the intersection point if they dont then they will reach Null


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        currentNode = headA
        while currentNode:
            lenA += 1
            currentNode = currentNode.next
        lenB = 0
        currentNode = headB
        while currentNode:
            lenB += 1
            currentNode = currentNode.next
        while lenA > lenB:
            headA = headA.next
            lenA -= 1
        
        while lenB > lenA:
            headB = headB.next
            lenB -= 1
        slow = headA
        fast = headB
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow