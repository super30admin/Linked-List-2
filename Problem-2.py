# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        #edge case
        if not head or not head.next:
            return
        fast = head
        slow = head
        prev = None
        #find mid
        while fast and fast.next:
            fast = fast.next.next
            prev = slow
            slow = slow.next
        prev.next = None
        previous = None
        #reverse half of the array
        while slow:
            myNext = slow.next
            slow.next = previous
            previous = slow
            slow = myNext    
        iterator = head
        #join both halfs
        while  iterator and iterator.next:
            temp = iterator.next
            iterator.next = previous
            previous = previous.next
            iterator.next.next = temp
            iterator = temp
        iterator.next = previous