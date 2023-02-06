/*RIGHT SHIFT*/
/*
 * Video : (take you forward) https://www.youtube.com/watch?v=9VPm6nEbVPA
 *  Time Complexity: O(n) 
	Auxiliary Space: O(1)
 */
package linkedList;

public class RotateLL {
	static SinglyLL s= new SinglyLL();
	static Node head;
	static class Node {
		int data;
		Node next;
		public Object head;
		
		Node (int data){
			this.data=data;
			next = null;
		}
	}
	
	linkedList.SinglyLL.Node rotate(linkedList.SinglyLL.Node head,int k) {
		// Corner or edge cases
		 if (head == null || head.next == null|| k == 0) 
			 return head;
		 
		 // Storing head value in temp.
		linkedList.SinglyLL.Node temp=head;
		Node next = null;
		while(temp.next!=null ) {
			temp=temp.next;
		}
		int l=s.length(); //length of linkedd list
		temp.next=head; // last node
		
		// To avoid more rotations when k value is more than length.
		// Bcz, k%l gives you the actual no. of rotations you have to do.
		// Ex: l=5 and k=12, So k%l=2, These are the actual no.of rotations,
		// you are going to do even after 12 iterations, # here you are saving 10 iterations.
		k = k % l; 
		
		// Taking l-k, so that from first we can break chain, before kth node. 
		k = l - k; // Elements :5, Rotating last two. Means before kth node we can break chain.
		          
		
		while(k-- > 0) {
			//System.out.println("d:"+temp.data);
			temp=temp.next;
			//System.out.println("d1:"+temp.data);
		}
		head=temp.next; // making 4th node as head, as it is first after rotating
		temp.next=null; // After kth node breaking node
	    return head;
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
		System.out.println("The Original linked list is:");
		s.print();
		System.out.println();
		
		RotateLL r = new RotateLL();
		int k = 3; // same output even with 12
		// Storing the return, value of rotate in new head and passing it to the printlist.
		linkedList.SinglyLL.Node new_head = r.rotate(s.head,k);
		System.out.println("The Roteted Linked list is: ");
		r.printList(new_head);

	}
}
