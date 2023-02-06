//Dynamic Memory Allocation...
package linkedList;
import linkedList.SinglyLL;

public class stackUsingLL {
	
	static SinglyLL sl=new SinglyLL();
	void push(int data) {
		sl.insertingAtStart(data); //Inserting at First position
	}
	
	void pop() {
		sl.delete(0); //Deleting from first
	}

	public static void main(String[] args) {
		stackUsingLL s= new stackUsingLL();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		sl.print();
		System.out.println();
		s.pop();
		s.pop();
		sl.print();

	}
}
