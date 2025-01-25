def get_middle_node(self, head):
    slow = fast = head
    while fast and fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    
    return slow

def reverse_linked_list(self, head):
    prev = None
    curr = head
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    
    return prev

def reorderList(self, head: Optional[ListNode]) -> None:
    """
    Do not return anything, modify head in-place instead.
    """
    # tc O(n), sc O(1).

    # find the middle node
    middle_node = self.get_middle_node(head)
    
    head2 = middle_node.next
    middle_node.next = None

    # reverse second half
    head2 = self.reverse_linked_list(head2)

    curr1, curr2 = head, head2
    sentinel = ListNode()
    prev = sentinel
    while curr1 and curr2:
        prev.next = curr1
        curr1 = curr1.next
        prev = prev.next

        prev.next = curr2
        curr2 = curr2.next
        prev = prev.next
    
    prev.next = curr1

    return sentinel.next