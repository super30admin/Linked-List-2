# Problem2 (https://leetcode.com/problems/reorder-list/)
# // Time Complexity : O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

def reverseSecondHalf(head):
    prev = None
    curr = head.next
    fast = curr.next
    while fast:
        curr.next = prev
        prev = curr
        curr = fast
        fast = fast.next
    curr.next = prev
    return curr


def reorderList(head):
    if head is None or head.next is None or head.next.next is None:
        return head

    # finding middle element
    slow = head
    fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    # slow is middle element

    # reversing second half
    prev = None
    curr = slow.next
    # splitting the second half
    slow.next = None
    while curr:
        fast = curr.next
        curr.next = prev
        prev = curr
        curr = fast

    # merge 2 halves
    ptr1 = head
    ptr2 = prev
    while ptr2:
        temp = ptr1.next
        ptr1.next = ptr2
        ptr2 = ptr2.next
        ptr1.next.next = temp
        temp = temp.next
