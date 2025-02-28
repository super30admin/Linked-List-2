# The code finds the intersection node of two linked lists by traversing both lists simultaneously,
#  switching heads when reaching None, ensuring both pointers travel the same total distance.

# Time Complexity: O(M + N) (Both pointers traverse at most M + N steps, where M and N are the lengths of the lists).
# Space Complexity: O(1) (Uses only two pointers).

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        pa = headA
        pb = headB
        while pa!=pb:
            pa = headB if pa is None else pa.next
            pb = headA if pb is None else pb.next
        return pa
        