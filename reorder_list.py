###
# Approach:
#       1. Use slow and fast pointers to find the middle of the list.
#       2. Reverse the second half of the list starting from the middle.
#       3. Merge the first half and the reversed second half, node by node.
#        Time Complexity: O(n) — each node is visited at most twice
#        Space Complexity: O(1) — in-place rearrangement without extra storage
###
class ListNode:
    def __init__(self, val=0, next = None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head):
        if not head:
            return
        slow = head
        fast = head
        first = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev = None
        curr = slow
        while curr:
            newnode = curr.next
            curr.next = prev
            prev = curr
            curr = newnode
        second = prev
        while second.next:
            temp1 = first.next
            temp2 = second.next

            first.next = second
            second.next = temp1

            first = temp1
            second = temp2
    
    def main(self):
        n1 = ListNode(1)
        n2 = ListNode(2)
        n3 = ListNode(3)
        n4 = ListNode(4)
        n5 = ListNode(5)
        n1.next = n2
        n2.next = n3
        n3.next = n4
        n4.next = n5

        print("Original list:")
        curr = n1
        while curr:
            print(curr.val, end=" -> " if curr.next else "\n")
            curr = curr.next

        self.reorderList(n1)

        print("Reordered list:")
        curr = n1
        while curr:
            print(curr.val, end=" -> " if curr.next else "\n")
            curr = curr.next

Solution().main()