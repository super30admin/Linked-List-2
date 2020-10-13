// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next: return
        slow, fast = head, head
        while fast and fast.next: 
            slow = slow.next
            fast = fast.next.next
        second_start = slow.next
        slow.next = None
        prev, curr = None, second_start
        while curr: 
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp 
        reversed_head = prev
        start = head
        while reversed_head: 
            temp1 = start.next 
            temp2 = reversed_head.next
            start.next = reversed_head 
            reversed_head.next = temp1
            reversed_head = temp2 
            start = temp1
        