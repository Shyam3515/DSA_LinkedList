package linkedList;
import linkedList.SinglyLL;
public class queueUsingLL {
	static SinglyLL sl=new SinglyLL();
	void push(int data) {
		sl.insert(data); //Inserting at last position
	}
	
	void pop() {
		sl.delete(0); //Deleting from first
	}

	public static void main(String[] args) {
		queueUsingLL q= new queueUsingLL ();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		sl.print();
		System.out.println();
		q.pop();
		q.pop();
		sl.print();

	}

}
