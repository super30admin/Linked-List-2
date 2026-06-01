class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        if head is None or head.next is None:
            return

        nodeList = []
        curr = head
        while curr is not None:
            nodeList.append(curr)
            curr = curr.next

        left = 0
        right = len(nodeList) - 1
        while left < right:
            nodeList[left].next = nodeList[right]
            left += 1

            if left < right:
                nodeList[right].next = nodeList[left]
                right -= 1

        nodeList[left].next = None

# Time: O(n)
# Space: O(n)