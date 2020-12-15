# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
#O(N) time and space
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        #constructor is called once so so use it as much as you want
        #next() and hasnext() multiple calls should be O(1)
        def inorder(root):
            stack = []
            res = []
            while root or stack:
                if root:
                    stack.append(root)
                    root = root.left
                else:
                    curr = stack.pop()
                    res.append(curr.val)
                    root = curr.right   
            return res
        #built inorder array
        self.res=inorder(root)
        self.len=len(self.res)
        self.i=0

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        #accesing elements from front
        if self.i<=self.len:
            popped=self.res[self.i]
            self.i+=1
        return popped
        
        # popped=self.res.pop(0)
        # return popped

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        #checking length of array
        return self.i<self.len
        #return len(self.res)!=0


#Method2-making next() function complex O(1) O(N)
# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, x):
# #         self.val = x
# #         self.left = None
# #         self.right = None

# class BSTIterator:

#     def __init__(self, root):

#         # Stack for the recursion simulation
#         self.stack = []

#         # Remember that the algorithm starts with a call to the helper function
#         # with the root node as the input
#         self._leftmost_inorder(root)

#     def _leftmost_inorder(self, root):

#         # For a given node, add all the elements in the leftmost branch of the tree
#         # under it to the stack.
#         while root:
#             self.stack.append(root)
#             root = root.left

#     def next(self) :
#         """
#         @return the next smallest number
#         """

#         # Node at the top of the stack is the next smallest element
#         topmost_node = self.stack.pop()

#         # Need to maintain the invariant. If the node has a right child, call the
#         # helper function for the right child
#         if topmost_node.right:
#             self._leftmost_inorder(topmost_node.right)
#         return topmost_node.val

#     def hasNext(self) :
#         """
#         @return whether we have a next smallest number
#         """
#         return len(self.stack) > 0
        


# # Your BSTIterator object will be instantiated and called as such:
# # obj = BSTIterator(root)
# # param_1 = obj.next()
# # param_2 = obj.hasNext()