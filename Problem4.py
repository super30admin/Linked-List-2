#I used a two-pointer technique to efficiently find the intersection point. I initialize two pointers, one for each list. Then, I traverse both lists simultaneously. When a pointer reaches the end of its list, I redirect it to the head of the other list. This process continues until both pointers meet at the same node (which is either the intersection point or null if there's no intersection). The key insight is that by switching lists when reaching the end, both pointers will travel the same total distance before meeting, regardless of the individual list lengths. This approach has a time complexity of O(N+M), where N and M are the lengths of the two lists, and uses only O(1) extra space.


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if not headA or not headB:
            return None

        pointerA, pointerB = headA, headB

        while pointerA != pointerB:
            pointerA = pointerA.next if pointerA else headB
            pointerB = pointerB.next if pointerB else headA

        return pointerA