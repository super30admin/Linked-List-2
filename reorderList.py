"""
We find middle of the list using slow and fast pointers.
Then we reverse the second half.
Later, merge both halves alternately.
"""
"""
Time Complexity: O(N) – Find middle + reverse + merge
Space Complexity: O(1) – In-place
"""

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class reorderList:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return

       
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next


        prev, curr = None, slow.next
        slow.next = None  
        while curr:
            next_temp = curr.next
            curr.next = prev
            prev = curr
            curr = next_temp

      
        first, second = head, prev
        while second:
            tmp1, tmp2 = first.next, second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2


def build_linked_list(values):
    dummy = ListNode()
    curr = dummy
    for v in values:
        curr.next = ListNode(v)
        curr = curr.next
    return dummy.next

def print_linked_list(head):
    res = []
    while head:
        res.append(head.val)
        head = head.next
    print(res)


if __name__ == "__main__":
    head = build_linked_list([1, 2, 3, 4, 5])
    obj = reorderList()
    obj.reorderList(head)
    print_linked_list(head)  
