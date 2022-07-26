'''

## Problem 173: Binary search tree iterator

## Author: Neha Doiphode
## Date:   07-23-2022

## Description:
    Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

    BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
    The root of the BST is given as part of the constructor.
    The pointer should be initialized to a non-existent number smaller than any element in the BST.
    boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
    int next() Moves the pointer to the right, then returns the number at the pointer.

    Notice that by initializing the pointer to a non-existent smallest number,
    the first call to next() will return the smallest element in the BST.

    You may assume that next() calls will always be valid.
    That is, there will be at least a next number in the in-order traversal when next() is called.

## Examples:
    Example 1:
                7
            /       \
           3        15
                  /    \
                 9     20


        Input:
                ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
                [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
        Output:
                [null, 3, 7, true, 9, true, 15, true, 20, false]

        Explanation:
                    BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
                    bSTIterator.next();    // return 3
                    bSTIterator.next();    // return 7
                    bSTIterator.hasNext(); // return True
                    bSTIterator.next();    // return 9
                    bSTIterator.hasNext(); // return True
                    bSTIterator.next();    // return 15
                    bSTIterator.hasNext(); // return True
                    bSTIterator.next();    // return 20
                    bSTIterator.hasNext(); // return False

## Constraints:
    The number of nodes in the tree is in the range [1, 105].
    0 <= Node.val <= 106
    At most 105 calls will be made to hasNext, and next.

## Follow up:
    Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?

## Time complexity: O(n), where n is number of nodes in the tree.

## Space complexity: O(n), since we build an auxiliary list to maintain sorted order of nodes in the tree.

'''

## Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
# Using inorder traversal recursive

class BSTIterator:
    l = []
    itr = 0
    def __init__(self, root: Optional[TreeNode]):
        self.l = []
        self.inorder(root)
        self.l.insert(0, TreeNode(-1))

    def inorder(self, root):
        if root == None:
            return
        self.inorder(root.left)
        self.l.append(root)
        self.inorder(root.right)

    def next(self) -> int:
        '''
        # Time complexity: O(1)
        '''
        self.itr += 1
        return self.l[self.itr].val

    def hasNext(self) -> bool:
        '''
        #Time complexity: O(1)
        '''
        if self.itr == len(self.l) - 1:
            return False
        return True
'''

class BSTIterator:
    '''
    Using inorder traversal iterative
    '''
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self._inorder_iterative(root)

    def _inorder_iterative(self, root: TreeNode) -> None:
        while root != None:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        top_node = self.stack.pop()
        if top_node.right:
            self._inorder_iterative(top_node.right)

        return top_node.val

    def hasNext(self) -> bool:
        if len(self.stack) == 0:
            return False
        return True

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
