# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(1)
# Logic: use two pointer to reach to the mid + 1 element, reverse 2nd half of the list. use 2 pointer now to traverse
# through both the lists adding elements in the required fashion. Do this while element in 2nd list exists.

class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def __init__(self):
        self.head = None

    def print_list(self):
        cur_node = self.head
        while cur_node:
            print(cur_node.val, end=" ")
            cur_node = cur_node.next

    def append(self, data):
        new_node = Node(data)

        if self.head is None:
            self.head = new_node
            return

        last_node = self.head
        while last_node.next:
            last_node = last_node.next
        last_node.next = new_node

    def reorderList(self, head) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        p = head
        q = head
        prev = None
        while q.next and q.next.next:
            q = q.next.next
            p = p.next
        curr2 = p.next
        p.next = None
        # prev.next = None
        # curr2 = p
        prev = None
        while curr2:
            nxt = curr2.next
            curr2.next = prev
            prev = curr2
            curr2 = nxt
        curr2 = prev
        curr1 = head
        while curr2:
            temp = curr1.next
            curr1.next = curr2
            curr1 = temp
            temp = curr2.next
            curr2.next = curr1
            curr2 = temp


llist = Solution()
llist.append(1)
llist.append(2)
llist.append(3)
llist.append(4)
llist.append(5)
llist.print_list()
print()
llist.reorderList(llist.head)
llist.print_list()
