"""
Approach:
    Use two pointers (p1 and p2) traversing both lists. When either pointer reaches
    the end of a list, redirect it to the head of the other list. They will either 
    meet at the intersection node or both reach None if no intersection.

    Time Complexity: O(m + n), where m and n are the lengths of the two lists.
    Space Complexity: O(1), uses constant space.
"""

class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next

class solution:
    def getIntersectionNode(self, headA, headB):
        p1 = headA
        p2 = headB
        while p1 != p2:
            p1 = p1.next if p1 else headA
            p2 = p2.next if p2 else headB
        return p1

def main():
    # Shared part (intersection)
    intersect = ListNode(8, ListNode(10))

    # List A: 4 -> 1 -> 8 -> 10
    headA = ListNode(4, ListNode(1, intersect))

    # List B: 5 -> 0 -> 1 -> 8 -> 10
    headB = ListNode(5, ListNode(0, ListNode(1, intersect)))

    sol = solution()
    result = sol.getIntersectionNode(headA, headB)
    print("Intersection at node with value:", result.val if result else "No intersection")

if __name__ == "__main__":
    main()