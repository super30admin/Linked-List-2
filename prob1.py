# BST Iterator implementation
# Time Complexity: O(1) for next() and hasNext(), Complexity for next() is O(n*h), since 75% of the time--the elements are leaf and root of the leaf node, the amortization time complexity is O(n) where value of h is one.
# Space Complexity: O(h) for the stack where h is the height of the tree

class BSTIterator:
    def __init__(self, root):
        self.stack = [] 
        self.left_node(root)  # Initialize by pushing all leftmost nodes starting from root onto the stack

    def left_node(self, node):
        # Push all the left children of `node` onto the stack until the leftmost node
        while node:
            self.stack.append(node)  # Save the traversal path 
            node = node.left

    def next(self):
        topmost_node = self.stack.pop()  # Pop the top node from stack (next smallest)

        # If the popped node has a right subtree,
        # push all its leftmost nodes onto the stack to maintain in-order traversal
        if topmost_node.right:
            self.left_node(topmost_node.right)

        return topmost_node.val

    def hasNext(self):
        # Return True if the stack is not empty, meaning there are still nodes to visit
        return len(self.stack) > 0
