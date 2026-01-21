''' Time Complexity : O(n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : 1. FInd the middle
              2. Reverse the second half
              3. Merge both list
'''

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        #find middle
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        #reverse second haf list
        prev = None
        curr = slow.next
        slow.next = None

        while curr :
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        slow = head
        fast = prev
        while fast:
            temp1 = slow.next
            slow.next = fast
            temp2 = fast.next
            fast.next = temp1
            slow = temp1
            fast = temp2