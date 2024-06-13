# Time Complexity : O(m+n), where m and n are the lengths of the two lists
# Space Complexity : O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None

        # Calculate the length of both linked lists
        m, n = 0, 0
        cur = headA
        while cur is not None:
            cur = cur.next
            m += 1
        cur = headB
        while cur is not None:
            cur = cur.next
            n += 1

        # Adjust the starting point of the longer list
        while m > n:
            headA = headA.next
            m -= 1
        while n > m:
            headB = headB.next
            n -= 1

        # Find the intersection node
        while headA is not None:
            if headA == headB:
                return headA
            headA = headA.next
            headB = headB.next

        return None

# Helper functions to create and print linked lists
def create_linked_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for val in values[1:]:
        current.next = ListNode(val)
        current = current.next
    return head

def create_intersecting_lists(common, list1, list2):
    common_head = create_linked_list(common)
    head1 = create_linked_list(list1)
    head2 = create_linked_list(list2)

    if head1 is None:
        head1 = common_head
    else:
        cur = head1
        while cur.next is not None:
            cur = cur.next
        cur.next = common_head

    if head2 is None:
        head2 = common_head
    else:
        cur = head2
        while cur.next is not None:
            cur = cur.next
        cur.next = common_head

    return head1, head2

def print_linked_list(head):
    values = []
    current = head
    while current is not None:
        values.append(current.val)
        current = current.next
    print(" -> ".join(map(str, values)))

# Example 1
common = [8, 4, 5]
list1 = [4, 1]
list2 = [5, 6, 1]
headA1, headB1 = create_intersecting_lists(common, list1, list2)
sol = Solution()
intersection1 = sol.getIntersectionNode(headA1, headB1) # Output : 8
print("Example 1 Intersection Node:")
print(intersection1.val if intersection1 else "No intersection")

# Example 2
common = [2, 4]
list1 = [1, 9, 1]
list2 = [3]
headA2, headB2 = create_intersecting_lists(common, list1, list2)
intersection2 = sol.getIntersectionNode(headA2, headB2) # Output : 2
print("Example 2 Intersection Node:")
print(intersection2.val if intersection2 else "No intersection")

# Example 3
common = []
list1 = [2, 6, 4]
list2 = [1, 5]
headA3, headB3 = create_intersecting_lists(common, list1, list2)
intersection3 = sol.getIntersectionNode(headA3, headB3) # Output : No intersection
print("Example 3 Intersection Node:")
print(intersection3.val if intersection3 else "No intersection")