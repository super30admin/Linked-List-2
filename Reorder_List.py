# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using two pointers. Since the list needs to be reordered, we need to find the middle element in the list.
# Then reverse the second half of the list 
# If the list is odd the middle node is in first half so start the second list from slow.next and point the previous list end to None
# Assign one of the pointers to the reversed list head and another pointer to original list head
# Then merge both the lists


class Solution:
    def reorderList(self, head: ListNode | None) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return head
        slow = head
        fast = head
        #find mid
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        #reverse second half
        head2 = slow.next
        slow.next = None
        prev = None

        while head2:
            currentNode = head2.next
            head2.next = prev
            prev = head2
            head2 = currentNode

        l1 = head
        l2 = prev
        #merge both lists
        while l2:
            currentNode = l1.next
            l1.next = l2
            l2 = l2.next
            l1.next.next = currentNode
            l1 = currentNode
            
        return head