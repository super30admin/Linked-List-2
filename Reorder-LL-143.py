# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach class Solution(object):
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        #1. find middle node
        #2. reverse from there
        #3. point the end node of first list to none
        #4. have 2 ptrs to merge the list back
        if head is None:
            return
        def reverse(node):
            curr = node
            prev = None
            while curr:
                new = curr.next
                curr.next = prev
                prev = curr
                curr = new
            return prev
        
        #1. find middle node
        slow = fast = head
        
        while fast and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        
        #2. reverse from there
        h2 = reverse(slow.next)
        
        #3. point the end node of first list to none
        slow.next = None
        h1 = head
        
        #4. have 2 ptrs to merge the list back
        while h1 != None and h2 != None:
            temp1 = h1.next
            h1.next = h2
            temp2 = h2.next
            h2.next = temp1
            h1 = temp1
            h2 = temp2
        return head
