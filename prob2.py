# Time Complexity : O(N) as we iterate over the entire list
# Space Complexity : O(1) as no extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took a few tries to get 
# the logic of merging correctly


# Your code here along with comments explaining your approach: 

# find the mid of the list using a 1x slow pointer and 2x fast pointer
# so slow.next is the second half
# reverse the second half 
#  and merge the first and second half

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val 
        self.next = next
class Solution:

    def reverseLL(self, head):

        if not head or not head.next:
            return head
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
    

    def reorderList(self, head):

        if head is None or head.next is None:
            return head
        
        slow = head
        fast = head

        # slow.next becomes the middle of the list
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        fast = self.reverseLL(slow.next)
        slow.next = None
        slow = head
        temp = None

        while fast is not None:
            temp = slow.next 
            slow.next = fast 
            fast = fast.next
            slow.next.next = temp
            slow = temp
        