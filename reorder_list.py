""" 
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Time Complexity: O(n)
Space Complexity: O(1)
"""

def reorderList(head):
    if not head or not head.next:
        return head
    
    # find the middle of the list
    slow, fast = head, head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    
    prev, curr = None, slow
    while curr:
        curr.next, prev, curr = prev, curr, curr.next
    
    
    first, second = head, prev
    while second.next:
        first.next, first = second, first.next
        second.next, second = first, second.next
    
    return head