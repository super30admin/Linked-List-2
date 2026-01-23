"""
time - o(n)
space - o(1)
we start with two pointers at their respective heads and move them forward one at a time till either of them reach the tail
once they reach the tail we switch the pointer to the other head and move them forward, eventually the two pointers meet at the intersection
this has to do with both pointers travelling the same distance if the sections before the intersection have the same length or if they don't
one travels the same distance as the other when the heads get flipped so they eventually end up at the intersection

"""
from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pa = headA
        pb = headB

        while pa != pb:
            pa = pa.next if pa else headB
            pb = pb.next if pb else headA
        return pa