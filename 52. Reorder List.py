# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reorderList(self, head) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return

        slow = head
        fast = head

        # finding Mid-point
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # reversing the second half of the list
        fast = self.reverse(slow.next)
        slow.next = None
        slow = head
        temp = None
        # print(slow)

        # merging the lists
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
        # curr = head
        li = []
        while True:
            li.append(head.val)
            if head.next is None:
                break
            head = head.next
        print(li)

    # fucntion for reversing the second half of the list
    def reverse(self, head):
        prev = None
        curr, fast = head, head.next

        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev
        return curr


if __name__ == "__main__":
    obj = Solution()
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(3)
    node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    head = node1
    # li = []
    # while True:
    #     li.append(head.val)
    #     if head.next is None:
    #         li.append(None)
    #         break
    #     head = head.next
    # print(li)
    obj.reorderList(head)

# Time Complexity = O(n). Finding the midpoint will be O(n/2) and reversing the second half will be O(n/2)
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, for fast = self.reverse(slow.next) I was passing head as my parameter. Then corrected it and it was working fine
