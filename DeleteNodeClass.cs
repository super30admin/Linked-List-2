internal class Program
{
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int val = 0, ListNode next = null)
        {
            this.val = val;
            this.next = next;
        }
    }
    static void Main(string[] args)
    {
        var head = new ListNode(1, null);
        var node1 = new ListNode(2, null);
        var node2 = new ListNode(3, null);
        var node3 = new ListNode(4, null);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        var current = head;
        Console.WriteLine("Before Deleting node");
        while (current != null)
        {
            Console.WriteLine(current.val);
            current = current.next;
        }
        DeleteNode(node3);
        current = head;
        Console.WriteLine("After Deleting node");
        while (current != null)
        {
            Console.WriteLine(current.val);
            current = current.next;
        }
    }

    public static void DeleteNode(ListNode node)
    {
        if (node == null)
        {
            return;
        }
        if (node.next == null)
        {
            Console.WriteLine("Cannot delete last node");
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;

    }
}