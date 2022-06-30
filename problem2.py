# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        secondHead = slow.next
        slow.next = None
        
        second = None
        while secondHead:
            second = ListNode(secondHead.val,second)
            secondHead = secondHead.next
        first = head
        while second != None:
            temp = first.next
            first.next = second
            temp2 = second.next
            second.next = temp
            first = temp
            second = temp2