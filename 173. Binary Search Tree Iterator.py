"""
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.controlled_dfs(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        if not self.hasNext():
            return -1
        else:
            min_elem = self.stack.pop()
            if min_elem.right:
                self.controlled_dfs(min_elem.right)
            return min_elem.val


    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        if (len(self.stack) > 0):
            return True
        else:
            return False

    def controlled_dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()