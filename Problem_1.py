'''
173 Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/description/

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.

Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.


Example 1:
Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
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

Constraints:
The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 106
At most 105 calls will be made to hasNext, and next.

Solution:
1. Function:   Time,    Space
   __init__(): O(1),    O(1)
   next():     O(H),    O(H)  (H=height of tree)
   hasNext():  O(1),    O(1)

'''
from typing import Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def build_tree_level_order(values):
    N = len(values)
    if N == 0:
        return None
    q = deque()
    tree = TreeNode(values[0])
    q.append(tree)
    i=0
    while i < N and q:
        node = q.popleft()
        left_index = 2*i+1
        right_index = left_index + 1
        if left_index < N and values[left_index] is not None:
            node.left = TreeNode(values[left_index])
            q.append(node.left)
        if right_index < N and values[right_index] is not None:
            node.right = TreeNode(values[right_index])
            q.append(node.right)
        i += 1
    return tree

class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.root = root
        self.val = float('-inf') # default value
        if self.root:
            self.stack = [self.val] # init stack with default value
        self.generate = self.get_val_generator(self.root)

    def get_val_generator(self, root):
        self.stack.pop() # pop the default value
        while self.root is not None or len(self.stack) != 0: # same as 'while tree or stack:'
            while self.root:
                self.stack.append(self.root)
                self.root = self.root.left
            self.root = self.stack.pop()
            #print(tree.value, end = " --> ")
            self.val = self.root.val
            yield self.val
            self.root = self.root.right

    def next(self) -> int:
        return next(self.generate)

    def hasNext(self) -> bool:
        if self.stack or self.root.right:
            return True
        else:
            return False

def run_BSTIterator():
    tests = [([7, 3, 15, None, None, 9, 20],[3, 7, True, 9, True, 15, True, 20, False])]
    for test in tests:
        root, ans = test[0], test[1]
        tree=build_tree_level_order(root)
        result=[]
        bi = BSTIterator(tree)
        result.append(bi.next())
        result.append(bi.next())
        result.append(bi.hasNext())
        result.append(bi.next())
        result.append(bi.hasNext())
        result.append(bi.next())
        result.append(bi.hasNext())
        result.append(bi.next())
        result.append(bi.hasNext())
        print(f"\nTree = {root}")
        print(f"Result = {result}")
        print(f"Pass: {ans==result}")

    tests = [([1],[True, 1, False])]
    for test in tests:
        root, ans = test[0], test[1]
        tree=build_tree_level_order(root)
        result=[]
        bi = BSTIterator(tree)
        result.append(bi.hasNext())
        result.append(bi.next())
        result.append(bi.hasNext())
        print(f"\nTree = {root}")
        print(f"Result = {result}")
        print(f"Pass: {ans==result}")

run_BSTIterator()
