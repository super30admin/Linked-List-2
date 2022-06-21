# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.st = []
        self.dfs(root)

    def next(self) -> int:
        result = self.st.pop()
        #curr = result.right
        self.dfs(result.right)
        #print(result.val)
        return result.val

    def hasNext(self) -> bool:
        return self.st != []

    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left
        #print(self.st)
# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

# Time Complexity = hasNext( ) and next( ) will be O(1) on avg and next() will O(h) in the worst case scenario
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No