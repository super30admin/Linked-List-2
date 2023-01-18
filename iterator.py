# Time Complexity :
# O(N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We keep our own queue and append elements to it in DFS manner. Everytime we need to check hasNext we just need to check if queue is empty
#For the next operation, we just need to pop the last element we added to the queue. When we do this, we also add the right subtree to the queue in a DFS manner

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.queue = []
        self.dfs(root)
        
    def dfs(self,root):
        while (root!= None):
            self.queue.append(root)
            root = root.left

    def next(self) -> int:
        elem = self.queue.pop()
        self.dfs(elem.right)
        return elem.val

    def hasNext(self) -> bool:
        return len(self.queue) != 0

