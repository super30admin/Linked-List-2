// In this problem we are using controlled recursion which is basically iterative way of doing recursion. we only push onto the stack the left side nodes. When we are asked for next we pop from the stack and traverse to the right side.
// Time Complexity: O(1) for next and hasNext
// Space Complexity: O(h) where h is the height of the tree

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BSTIterator(root: TreeNode?) {

    private var st = Stack<TreeNode>()

    init {
        dfs(root)
    }

    fun next(): Int {
        val result = st.pop()
        dfs(result.right)
        return result.`val`
    }

    fun hasNext(): Boolean {
       return !st.isEmpty()
    }

    fun dfs(root: TreeNode?) {
        var newRoot = root
        while(newRoot != null) {
            st.push(newRoot)
            newRoot = newRoot.left
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */