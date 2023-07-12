# Time complexity : O(n)
# Space complexity : O(1)

# The code ran on Leetcode

# Reverse the second half of the linked list since we need elements in reverse order. Combine the forward and reverse lists to get the result 

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
        slow = fast = head

        while (fast.next!=None and fast.next.next != None):
            slow = slow.next
            fast = fast.next.next

        def reverse(head):
            if head == None or head.next == None: return head
            reversed = reverse(head.next)
            head.next.next = head
            head.next = None
            return reversed

        head2 = reverse(slow.next)
        slow.next = None
        slow = head

        while slow and head2:
            temp1 = slow.next; temp2 = head2.next

            slow.next = head2
            head2.next = temp1
            slow = temp1; head2 = temp2
        return head






        
