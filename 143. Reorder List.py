# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : While finding the mid of linkedList, used or statement instead of and in while loop.

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        - divide the problem into 3 different subproblems
        - find mid point using slow-fast pointer, reverse second half
        - join the two linkedlist
        """
        # find the mid point 
        slow = head
        fast = head
        while ((fast != None) and (fast.next != None)):
            slow = slow.next
            fast = fast.next.next

        # reverse the second half
        prev = None
        curr = slow 
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        head2 = prev

        # merge the two list
        head1 = head
        while head2.next != None:
            temp = head1.next
            head1.next = head2
            temp2 = head2.next
            head2.next = temp
            head1 = temp
            head2 = temp2



