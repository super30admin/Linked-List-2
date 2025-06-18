# Approach:
# - Perform in-order traversal using a stack.
# - In __init__, push all left nodes to the stack (simulating in-order traversal).
# - next(): Pop from the stack (smallest element), then push all left children of its right subtree.
# - hasNext(): Return True if the stack is not empty.

# Time Complexity:
# - next(): Amortized O(1) per call (each node is pushed/popped once)
# - hasNext(): O(1)

# Space Complexity:
# - O(h), where h is the height of the tree (stack holds at most h nodes)

from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:

    def __init__(self, root):
        self.st = []
        self.dfs(root)
    
    def dfs(self, root):
        while root:
            self.st.append(root)
            root = root.left        

    def next(self) -> int:
        temp = self.st.pop()
        self.dfs(temp.right)
        return temp.val
        

    def hasNext(self) -> bool:
        return len(self.st) > 0


def build_tree(level_order):
    if not level_order or level_order[0] is None:
        return None
    root = TreeNode(level_order[0])
    queue = deque([root])
    i = 1
    while queue and i < len(level_order):
        node = queue.popleft()
        if i < len(level_order) and level_order[i] is not None:
            node.left = TreeNode(level_order[i])
            queue.append(node.left)
        i += 1
        if i < len(level_order) and level_order[i] is not None:
            node.right = TreeNode(level_order[i])
            queue.append(node.right)
        i += 1
    return root
def main():
    commands = ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
    inputs = [[[7, 3, 15, None, None, 9, 20]], [], [], [], [], [], [], [], [], []]
    output = []

    iterator = None

    for cmd, arg in zip(commands, inputs):
        if cmd == "BSTIterator":
            root = build_tree(arg[0])
            iterator = BSTIterator(root)
            output.append(None)
        elif cmd == "next":
            output.append(iterator.next())
        elif cmd == "hasNext":
            output.append(iterator.hasNext())

    print("Output:", output)

main()