# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I find the mid of list and then reverse the list from end to mid
# Then connect from one head to other head and other head to temp which is first next
# of first head. Repeating until slow is not null

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head: return head
        
        mid = head
        slow = head
        fast = head.next
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow
        
        nHead = self.reverse(mid, None)
        slow = head
        fast = nHead
        temp = slow.next
        while slow:
            slow.next = fast
            fast=fast.next
            slow.next.next = temp
            slow = temp
            if temp:
                temp = temp.next
        return head
        
    
    def reverse(self, head, prev):
        if not head.next:
            head.next = prev
            return head
        
        new_head = self.reverse(head.next, head)
        head.next = prev
        return new_head