# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.st = deque()
        self.dfs(root)

    def next(self) -> int:
        node = self.st.pop()
        self.dfs(node.right)
        return node.val
        

    def hasNext(self) -> bool:
        return len(self.st) != 0
        
    def dfs(self, root: TreeNode):
        while root!= None:
            self.st.append(root)
            root = root.left
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()

# Time Complexity : O(1) - Average case    O(h) - Worst case
# Space Complexity : O(h)
