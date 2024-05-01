## Problem2 (https://leetcode.com/problems/reorder-list/)

# Approach
# Set slow and fast pointer at head. While fast.next != None and fast.next.next !=None, increment fast by 2 and slow by 1 place. This will give us the middle of the linkedlist
# pass second half of the linkedlist to reversedList function that will reverse the list. Set slow.next to None to remove the link between mid and mid+1 node
# again set slow to head. While slow!= None and fast!=None, linked one node of slow with the same index fast node and reorder the LinkedList. return head

# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def reverseList(self,head):
        prev = None
        curr = head
        while(curr != None):
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev 


    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow,fast = head,head

        while(fast.next != None and fast.next.next !=None):
            fast = fast.next.next
            slow = slow.next


        fast = self.reverseList(slow.next)
        slow.next = None
        slow = head
        while(slow!= None and fast!=None):
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
           
        return head