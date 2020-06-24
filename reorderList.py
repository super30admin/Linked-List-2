# Time Complexity : O(n), where n is the length of the list.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # This problem will be solved by traversing to the middle of
    # the linked list, reversing the second half of the list and
    # merging the two lists in an alternating manner.
    def reorderList(self, head):
        # edge case
        if not head:
            return
        # find middle of list
        slow, fast = head, head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        # reverse second half of the list
        fast = self.reverse(slow.next)
        # pointers init
        curr, slow.next, slow = None, None, head
        # merge the two lists
        while fast != None:
            curr = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = curr
            slow = curr

    # code for reversing a Linked List
    def reverse(self, head):
        if not head:
            return None
        prev, next = None, head.next
        while next != None:
            head.next = prev
            prev = head
            head = next
            next = next.next
        head.next = prev
        return head
