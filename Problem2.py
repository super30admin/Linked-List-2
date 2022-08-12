# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
      # check if the head is empty or just one node, then return head
      if head is None or head.next is None:
            return head
        
        # finding the middle of the list, middle is at slow + 1 (slow.next)
        slow = fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        # now reverese the list starting from slow.next node, the result will be the head pointer which is store in fast
        fast = self.reverse(slow.next)
        
        # breaking the list by 2, one is the original half till middle and the other is reversed
        slow.next = None
        # reset the slow pointer to the head of the original list
        slow = head
        
        # Merge the two lists by using alternated node from the list
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
    # function to reverse the list
    def reverse(self, head):
        prev = None
        curr = head
        fast = head.next
        
        while fast is not None:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        
        return curr
