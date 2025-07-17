'''
143 Reorder List
https://leetcode.com/problems/reorder-list/description/

You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]



Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000

Solution:
1. Brute Force:
Start traversing from the head node of list. For each node, perform the following operations:
    Let current node = node
    Using a second pointer, traverse list again until the last node.
    Disconnect the last node from the list.
    Place the removed last node after the current node.
    Update current to its next node.
Time: O(N^2), Space: O(1)

2. Two-pointer approach:
Using a pair of slow and fast pointers, detect the middle node of the list
middle node = (N/2 + 1)th node, if N  = even
            = ((N+1)/2)th node, if N = odd

Now, we have two sublists:
left sublist = head -> ... -> mid
right sublist = mid + 1 -> ... -> tail

Now reverse the right sublist:
right sublist = tail -> ... -> mid + 1

Now merge the two sublists by taking one node from each sublist in an alternate fashion
https://youtu.be/6laukTeU1WY?t=1266

Time: O(N), Space: O(1)
'''
from linked_list import *

def reverse_list(head):
    if not head or not head.next:
        return head
    prev = None
    curr = head
    fast = head.next
    while fast:
        curr.next = prev
        prev = curr
        curr = fast
        fast = fast.next
    curr.next = prev

    return curr

def reorder_list(head):
    if not head or not head.next or not head.next.next:
        return head

    slow = head
    fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next


    # At this point, slow points to node no.
    # N/2 + 1, if N  = even
    # (N+1)/2, if N = odd
    # Note: the node nos. are 1-indexed (hence, head node = 1)

    # Reverse the sublist from the slow.next node to end of list
    rev_head = reverse_list(slow.next)

    # break the left sublist at mid node
    slow.next = None

    # Now merge the two sublists:
    # 1. left sublist starts from head and ends at slow
    # 2. right sublist starts from the end node and ends at slow+1 node
    forward = head
    backward = rev_head
    while forward and backward:
        fast_forward = forward.next
        fast_backward = backward.next
        forward.next = backward
        backward.next = fast_forward

        forward = fast_forward
        backward = fast_backward

def run_reorder_list():
    tests = [([1,2,3,4,5,6,7], [1,7,2,6,3,5,4]),
              ([1,2,3,4,5,6,7,8], [1,8,2,7,3,6,4,5]),
              ([], []),
              ([1], [1]),
              ([1,2], [1,2]),
              ([1,2,3], [1,3,2]),
    ]
    for test in tests:
        head, ans = test[0], test[1]
        sll = build_linked_list(head)
        reorder_list(sll)
        print(f"\nSLL = {sll.to_array()}")
        print(f"Reorder SLL = {sll.to_array()}")
        print(f"Pass: {ans == sll.to_array()}")

run_reorder_list()
