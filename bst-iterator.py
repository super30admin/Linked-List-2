# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

''' 
Time Complexity:
 next(): O(h) where h is the height of the tree, as we may need to traverse down to the leftmost node. 
 hasNext(): O(1) since it only checks if the stack is non-empty.
 dfs(): O(h) for the same reason as next().
Space Complexity: O(h) as we are using a stack to store the nodes, where h is the height of the tree. 

Approach:
We use a stack to store the nodes in the order of traversal. 
We start by pushing the root node onto the stack. 
Then, we traverse the left subtree of the root node, pushing each node onto the stack. 
Finally, we pop the root node from the stack and return its value.


'''
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.dfs(root)

    def next(self) -> int:
        res = self.stack.pop()
        self.dfs(res.right)
        return res.val

    def dfs(self, root):
        while root is not None:
            self.stack.append(root)
            root = root.left

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
