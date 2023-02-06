/*
 * Link : https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * Question : Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * Example: 
	Input: 1->2->3->4->5->6->7->8->NULL, K = 3 
	Output: 3->2->1->6->5->4->8->7->NULL 
	Input: 1->2->3->4->5->6->7->8->NULL, K = 5 
	Output: 5->4->3->2->1->8->7->6->NULL  
	
 * Algorithm: reverse(head, k) 

	1)Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. 
	Let the pointer to the next node be next and pointer to the previous node be prev. 
	See this post for reversing a linked list.
	2)head->next = reverse(next, k) ( Recursively call for rest of the list and link the two sub-lists )
	3)Return prev ( prev becomes the new head of the list (see the diagrams of an iterative method of this post )	
 */
package linkedList;

public class ReverseInGroupsWithSize {
	static SinglyLL s= new SinglyLL();
	static Node head;// head of list
    /* Linked list Node*/
	static class Node {
		int data;
		Node next;
		public Object head;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	
	linkedList.SinglyLL.Node reverse(linkedList.SinglyLL.Node head, int l)
    {
        if(head == null)
          return null;
        linkedList.SinglyLL.Node current = head;
        linkedList.SinglyLL.Node next = null;
        linkedList.SinglyLL.Node prev = null;
        int count = 0;
 
        /* Reverse first l nodes of linked list */
        while (count < l && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        /* next is now a pointer to (k+1)th node
        Recursively call for the list starting from
        current. And make rest of the list as next of
        first node */
     if (next != null)
         head.next = reverse(next, l);// After kth element, we have to repeat the process from (k+1)th element.
         
     // prev is now head of input list
     System.out.println("prev :"+prev.data);
     return prev;
    }
    
	void printList(linkedList.SinglyLL.Node new_head)
    {
		while (new_head != null) {
            System.out.print(new_head.data + " ");
            new_head = new_head.next;
        }
    }

	public static void main(String[] args) {
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(4);
		s.insert(5);
		s.insert(6);
		s.insert(7);
		System.out.println("The Original linked list is:");
		s.print();
		System.out.println();
		ReverseInGroupsWithSize r=new ReverseInGroupsWithSize();
		int l=3;
		linkedList.SinglyLL.Node new_head = r.reverse(s.head,l);
		System.out.println("The Roteted Linked list is: ");
		r.printList(new_head);
	}
}
