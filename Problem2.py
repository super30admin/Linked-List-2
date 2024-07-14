#I used a deque (double-ended queue) to efficiently access both ends of the list. First, I traverse the entire linked list, adding each node to the deque. Then, I start the reordering process by repeatedly popping the first node from the left of the deque and the last node from the right. I connect these nodes in the new order: the first node points to the last, and the last points to what was originally the first's next node. This process continues until there are fewer than two nodes left in the deque. If there's one node left, it becomes the new last node. Finally, I ensure the last node's next pointer is set to None to terminate the list.


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        queue = deque()
        node = head

        while node:
            queue.append(node)
            node = node.next

        last = None
        while len(queue) >= 2:
            first = queue.popleft()
            last = queue.pop()
            first.next, last.next = last, first.next

        if len(queue) == 1:
            last = queue.pop()
        
        if last:
            last.next = None

        return head
