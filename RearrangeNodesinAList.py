  ----------------------Rearrange nodes in a given order--------------------------------------   
# Time Complexity : O(3N) ~~~ O(N) N is the number of linked-list Nodes.
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# This is a 3 step procedure. First I found the middle element using slow and fast pointer, where slow moves by 1 step and fast moves by 2.
# Second, I reversed the second half of the LL.
# Third i used 2 pointers head and tail, then merged the LL using these 2 pointers and then moving forward the head and tail pointers. 



class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None:
            return None
        
        fast = slow = head
        # Slow will be the middle of the list
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        
		# Reverse list elements starting from the middle.
        prev, cur = slow, slow.next
        while cur:
            tmp = cur.next
            cur.next, prev = prev, cur
            cur = tmp
        
        tail = prev
        
        while tail != slow:
            temp = tail.next
            tail.next = head.next
            head.next = tail
            head = tail.next
            tail = temp
        
        slow.next = None