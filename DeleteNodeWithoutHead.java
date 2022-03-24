// Time Complexity : O(1)
// Space Complexity : O(1)
class DeleteNodeWithoutHead {	
	static class Node {
		int data;
		Node next;
		Node() {}
		Node(int data) { this.data = data; next = null;}
		Node(int data, Node next) { this.data = data; this.next = next; }
	}
	
	public void deleteNode(Node del) {
        if(del==null) return;
        //Provided that node can't be last node. Hence delete the node by replacing next node.
        del.data= del.next.data;
        del.next=del.next.next;
    }    
	
	// Driver code to test above 
    public static void main(String args[]) {
    	DeleteNodeWithoutHead ob = new DeleteNodeWithoutHead();
    	Node n1= new Node(1);
    	Node n2= new Node(2);
    	Node n3= new Node(3); 
		n1.next=n2;
		n2.next=n3;
		
		System.out.print("Final linked list :");	
		ob.deleteNode(n1);
		while(n1!=null) {
			System.out.print("\t"+n1.data);
			n1=n1.next;
		}
    } 
}
