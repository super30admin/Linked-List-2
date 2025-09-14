/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
// Time complexity - Amortized(1)
// Space complexity - O(h), height of the BST
class BSTIterator {
	private stack: TreeNode[];
	constructor(root: TreeNode | null) {
		this.stack = [];
		this.dfs(root);
	}

	next(): number {
		const temp = this.stack.pop();
		this.dfs(temp.right);
		return temp.val;
	}

	dfs(curr: TreeNode | null) {
		while (curr != null) {
			this.stack.push(curr);
			curr = curr.left;
		}
	}

	hasNext(): boolean {
		return this.stack.length !== 0;
	}
}
