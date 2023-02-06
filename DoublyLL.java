package linkedList; 
public class DoublyLL {
	static class Node{
		int data; // value--> Int data type
		// address of next node
		Node next; 
		Node prev; //address of prev node
		Node(int data){
			this.data = data;
			next= null;
			prev=null;
		}
	}

	//Inserting a node
	Node head; 
	Node prev=null;
	void insert(int data) { 
		Node newnode = new Node(data);
		newnode.data=data;
		newnode.next = null;
		newnode.prev = null;
		
		if(head==null) {
			head = newnode; //if,head=null make head as first node 
			return;
		}	
		else {
			Node temp=head;// created temp, to hold data, to travel from first to insert position
			while(temp.next!=null) {
				temp=temp.next;// jumps to next node until we got position
			}
			temp.next=newnode; 
			newnode.prev=temp;
			newnode.next=null;
		}
	}
	
	//Inserting at start
	void insertingAtStart(int data) {
		Node newnode = new Node(data);
		newnode.data=data;
		newnode.next = null;
		
		newnode.next = head; //here we are linking 
		head.prev=newnode;//head previous node to newnode
		head=newnode; 
	}
	
	//Insert In Between
	void insertingInBetween(int index,int data) {
		Node newnode = new Node(data);
		newnode.data=data;
		newnode.next = null;
		
		if(index==0) {
			insertingAtStart(data);
		}
		else {
			Node n = head; // created n, to hold data, to travel from first to insert position
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
				Node store = n.next; // Strore the value of next of adding node. 
				                   //As we have to delink a node, when we add a node, next to n. 
				n.next=newnode; 
				newnode.prev=n;
				newnode.next=store;
				store.prev=newnode;//here, store = next node of new node
			}
	}
	
	//Deleting Elements
	void delete(int index) {
		Node n1=null;
		if(index==0) {
			n1=head;// Storing data of head in n1.
			head = head.next;
			head.prev=null;
			System.out.println("The deleted element is: "+n1.data);
		}
		else {
			Node n = head; // created n, to hold data, to travel from first to insert position
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
			n.next=n.next.next; //a(next) = b(next) i.e: storing address of c in a.
			n.next.prev=n; // storing c (prev) in a
		}
	}
	
	//Peek element
	void peek() {
		Node n1=head;
		System.out.print("The top most element is : ");
		if(head==null) {
			System.out.println(0);
		}
		else {
			System.out.println(n1.data);
		}
	}
	
	//Number of nodes
			int length() {
				int count=0;
				Node p=head;
				while(p!=null) {
					count+=1;
					p=p.next;
				}
				return count;
			}
		
	
	
	//Printing data
	public void print() {
		Node temp=head; //As we have to traverse from first
		System.out.println("Elements in Linked List are:");
		while(temp!=null) {// Traverse to last position
			// Prints data that is present in temp.
			System.out.print(temp.data +" ");
			temp=temp.next;
		}
		
	}
	
	public static void main(String[] args) {
		DoublyLL l = new DoublyLL();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(5);
		l.insertingAtStart(0);
		l.insertingInBetween(1, 4);
		System.out.println("Number of nodes present are : "+l.length());
		l.print();
		l.delete(3);
		l.delete(0);
		
		System.out.println("Number of nodes present are : "+l.length());
		l.peek();
		l.print();
		

		
	}

}
