# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.helper(root)
    
    def helper(self, root): 
        while root is not None:
            self.stack.append(root)
            root = root.left

    # Time Complexity --> O(logn) considering the worst case scenario, O(1) if Amortized
    # Explanation --> At the last level of a BST, we have n/2 nodes and the time complexity to do DFS on them is O(1) since there are no child nodes. Similarly, for a level above it each node has only 1 child node which is the last level nodes and so the DFS takes O(1). Since 75% of the nodes take O(1), we can say Amortized is O(1)
    # Space Complexity --> O(logn) which is height of the tree added to the stack
    def next(self) -> int:
        next_ele = self.stack.pop()
        self.helper(next_ele.right)
        return next_ele.val

    # Time Complexity --> O(1) 
    def hasNext(self) -> bool:
        return len(self.stack)>0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
