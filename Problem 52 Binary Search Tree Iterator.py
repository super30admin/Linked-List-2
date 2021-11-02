# Did this code successfully run on Leetcode: Yes
# Time Complexity: next() --> O(n)
# Time Complexity: hasNext() --> O(1)
# Space Complexity: O(n)
# Logic: build a stack with all the left values, when next is called pop the element & check if its right is present
# or not. if present append all left in stack again & return the node's value.

class BSTIterator:

    def __init__(self, root):
        self.stack = []
        self._build_stack(root)

    def _build_stack(self, node):
        while node:
            self.stack.append(node)
            node = node.left

    def next(self) -> int:
        curr_node = self.stack.pop()
        if curr_node.right:
            self._build_stack(curr_node.right)
        return curr_node.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0
