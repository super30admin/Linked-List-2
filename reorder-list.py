'''
Problem: https://leetcode.com/problems/reorder-list/ 

Time Complexity: 
   Finding the middle of the list: O(n)
   Reversing the second half: O(n)
   Merging the two halves: O(n) 
   Total Time Complexity: O(n)

Space Complexity: O(1) since we are modifying the list in-place without using extra space. 

Approach: 
1. Use the slow and fast pointer technique to find the middle of the linked list.
2. Reverse the second half of the linked list.
3. Merge the two halves.

'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        # Find the middle element
        slow = fast = head

        # fast.next for odd length and fast.next.next for even length
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # reverse the list from the middle element
        curr = slow.next
        prev = None
        slow.next = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        # merge the original first half with reversed second half

        fast = prev
        slow.next = None
        slow = head
        while fast:
            temp1 = slow.next
            temp2 = fast.next
            slow.next = fast
            fast.next = temp1
            slow = temp1
            fast = temp2
