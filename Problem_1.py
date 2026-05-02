# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root):
        self.st = []
        self.st.append(root)
        self._dfs(root.left)

    def _dfs(self, root):
        if not root:
            return
        self.st.append(root)
        self._dfs(root.left)

    def next(self):
        top = self.st.pop()
        if top.right:
            self._dfs(top.right)
        return top.val

    def hasNext(self):
        return len(self.st) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
