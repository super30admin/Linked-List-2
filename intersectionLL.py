"""
Use two pointers A and B beginning from each list head.
Move them forward; when one reaches the end, redirect to the other list’s head.
They will meet at the intersection or both reach None.
"""
"""
Time Complexity: O(m + n) ; m = length of A, n = length of B
Space Complexity: O(1) — Constant space
"""

from typing import Optional

class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None

class intersectionLL:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None

        a, b = headA, headB

        while a != b:
            a = a.next if a else headB
            b = b.next if b else headA

        return a  


def build_intersecting_lists(shared, listA_vals, listB_vals):
    shared_head = None
    for val in reversed(shared):
        node = ListNode(val)
        node.next = shared_head
        shared_head = node

    headA, headB = None, None
    for val in reversed(listA_vals):
        node = ListNode(val)
        node.next = headA
        headA = node
    for val in reversed(listB_vals):
        node = ListNode(val)
        node.next = headB
        headB = node

    tailA, tailB = headA, headB
    while tailA and tailA.next:
        tailA = tailA.next
    while tailB and tailB.next:
        tailB = tailB.next

    if tailA: tailA.next = shared_head
    if tailB: tailB.next = shared_head

    return headA, headB, shared_head


if __name__ == "__main__":
    listA, listB, shared = build_intersecting_lists([8, 4, 5], [4, 1], [5, 6, 1])
    obj = intersectionLL()
    intersection = obj.getIntersectionNode(listA, listB)
    print(intersection.val if intersection else None)
