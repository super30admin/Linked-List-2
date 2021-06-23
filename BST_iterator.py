# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator(object):
    # iterator : when user just have access to next.. not the indexes
    # key idea : controlled recursion
    # creating a contructor and putting all nodes will take extra space so we would preer to take private stack and
    # control the recursion by putting just next node

    # TC: 

    # initialization
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack=[]
        self.dfs(root)
    
    # Pushing all left nodes
    def dfs(self, node):
        while node:
            self.stack.append(node)
            node=node.left

    # return next element
    # TC: O(1) average and worst case : O(h)
    def next(self):
        """
        :rtype: int
        """
        node = self.stack.pop()
        x=node.right
        while x:
            self.stack.append(x)
            x=x.left
        return node.val

    #TC : O(1)
    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack)>0
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()