"""
// Time Complexity : O(n)
// Space Complexity : O(n)  //recursive stack for reversing the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// Your code here along with comments explaining your approach
Algorithm explanation
We divide our algorithm into 3 main parts
a) Finding the middle of the list using slow, fast pointer (Floyd's algo)
b) Reverseing middle_node.next
c) Merging the first half of the list till middle node and reversed 
list using three pointer approach (temp1,temp2, temp1next)
"""

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
        3 functions
        1. Finding the middle of the list
        2. Finding the reverse of the sublist
        3. Merging the two list
        """
        
        def find_middle(head):
            slow = fast = head
            while fast.next and fast.next.next:
                slow = slow.next
                fast = fast.next.next
            return slow
        
        def rev_list(head):
            if not head or not head.next:
                return head
            temp = rev_list(head.next)
            head.next.next = head
            head.next = None
            return temp
        
        def merge_two_list(head1,head2):
            temp1 = head1
            temp2 = head2
            while temp2:
                temp1next = temp1.next
                temp1.next = temp2
                temp2 = temp2.next
                temp1.next.next = temp1next
                temp1 = temp1next
        
        if not head or not head.next:
            return
        middle_node = find_middle(head)
        head2 = rev_list(middle_node.next)
        middle_node.next = None
        middle_node = head
        merge_two_list(middle_node,head2)