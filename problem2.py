'''
## Problem2 (https://leetcode.com/problems/reorder-list/)

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: No

'''

'''
Approach:
In the reordered list, the sequence of first half remains same while the sequence of second half is reversed.
Thus, reverse the second half and merge alternatively with the first half.

'''

# Definition for singly-linked list.
# class ListNode:
#   def __init__(self, val=0, next=None):
#     self.val = val
#     self.next = next
class Solution:
  def reorderList(self, head):
    """
    Do not return anything, modify head in-place instead.
    """
    # edge cases
    if not head or not head.next:
      return head

    # reach the middle node
    slow = head
    fast = head.next
    while fast and fast.next:
      slow = slow.next
      fast = fast.next.next

    # set the start of the first half and reversed second half
    head1 = head
    head2 = self.reverse(slow.next)
    slow.next = None

    # reconnect the nodes alternating between first half and reversed second half
    while head1 and head2:
      next1 = head1.next
      next2 = head2.next
      head1.next = head2
      head2.next = next1
      head1 = next1
      head2 = next2

  def reverse(self, head):
    prevNode = None
    currNode = head
    while currNode:
      nextNode = currNode.next
      currNode.next = prevNode
      prevNode = currNode
      currNode = nextNode
    return prevNode
