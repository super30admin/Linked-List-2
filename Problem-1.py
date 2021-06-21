"""
Approach: since this is an iterator, we cannot make everything available to the user at once. We need to implement
controlled recursion.
TC:
next --> O(n) worst, O(1) Amortized
hasNext--> O(1)
init --> O(n)
SC:
O(n)
"""
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = deque()
        self.dfs(root)

    def next(self) -> int:
        out = self.stack.pop()
        self.dfs(out.right)
        return out.val


    def hasNext(self) -> bool:
        if self.stack:
            return True
        else: return False

    def dfs(self, root):
        while root:
            self.stack.append(root)
            root = root.left


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()