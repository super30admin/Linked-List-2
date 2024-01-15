# Time Complexity : O(n), where n is the number of nodes in the linked list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes

# Definition for singly-linked list.
class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution:
    def reorderList(self, head: [ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        def reverselist(head):
            prev = None
            curr_node = head
            while curr_node is not None:
                temp = curr_node.next
                curr_node.next = prev
                prev = curr_node
                curr_node = temp
            return prev

        if not head or not head.next:
            return
        
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        head1 = head
        head2 = reverselist(slow.next)
        slow.next = None

        while head1 and head2:
            temp1 = head1.next
            temp2 = head2.next

            head1.next = head2
            head2.next = temp1

            head1 = temp1
            head2 = temp2