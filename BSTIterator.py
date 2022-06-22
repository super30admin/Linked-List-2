#TC:O(1) for both next and hasnext
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack=[]
        self.dfs(root)
    def dfs(self,root):
        while(root!=None):
            self.stack.append(root)
            root=root.left
            

    def next(self):
        """
        :rtype: int
        """
        curr= self.stack.pop()
        temp=curr.val
        self.dfs(curr.right)
        return temp

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack)!=0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()