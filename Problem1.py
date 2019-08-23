# Time Complexity : O(n) maybe.Having trouble with it. Can you please explain this?
# Space Complexity :maybe O(n) but not sure
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No



# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        if head:
            slow = fast = n1 = head
            l = 0

            while fast and fast.next:
                slow = slow.next
                fast = fast.next.next

            next_node = None
            while slow:
                temp = slow.next
                slow.next = next_node
                next_node = slow
                slow = temp
            while next_node.next is not None:
                temp1 = n1.next
                temp2 = next_node.next
                n1.next = next_node
                next_node.next = temp1
                next_node = temp2
                n1 = temp1

            return head

#Here first I found the middle element in the link list and then reversed the rest of the list. Then iterationg from the last element,
# till we have reached the middle element , we will insert the number ar appropriate position in linked list