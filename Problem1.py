# Time Complexity : O(1)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#use custom stack to stop the iteration wherever needed
class BSTIterator:
    
    def __init__(self, root: TreeNode):
        self.arr = []
        self.__dfs(root)
        
    def __dfs(self,root: TreeNode):
        node = root
        while node != None:
            self.arr.append(node)
            node = node.left   

    def next(self) -> int:
        node = self.arr.pop()
        self.__dfs(node.right)
        return node.val
        

    def hasNext(self) -> bool:
        return len(self.arr) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()