# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  This is a combination of three algorithms, first we find the middle of the list, 
# reverse the latter half and then criss cross merge both the lists
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        mid = middle(head)
        head2 = reverse(mid.next)
        mid.next = None
        crisscrossmerge(head, head2)

def middle(head):
    slow, fast = head, head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    return slow

def reverse(head):
    prev = None
    curr = head
    while curr:
        temp = curr.next
        curr.next = prev
        prev = curr
        curr = temp
    return prev

def crisscrossmerge(head1, head2):
    # Since head2 will be shorter
    while head2:
        temp = head1.next
        head1.next = head2
        head2 = head2.next
        head1.next.next = temp
        head1 = temp
    