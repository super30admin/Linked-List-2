## Time Complexity : O(n), n is number of nodes in tree
## Space Complexity : O(h),h is the height of the tree
## Did this code successfully run on Leetcode : Yes
#Approach:left most child of a node will give us the smallest element.
# The left inorder will ensure that the smallest element is at the top of the stack.Before moving on to the root of tgis we have to ensure if this node has right child.
# If it does we need to do left inorder traversal of the right subtree which will append all the left childs of right subtree on the stack.
# The top will again have the samllest element.


class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        self.left_inorder(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        top = self.stack.pop()
        if top.right:
            self.left_inorder(top)
        return top.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) > 0

    def left_inorder(self, root):
        while root:
            self.stack.append(root)
            root = root.left