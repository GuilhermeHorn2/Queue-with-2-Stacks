package misc;

public class My_Queue<T> {
	
	private Stack<T> s1 = new Stack();
	private Stack<T> s2 = new Stack();
	private static int reversed;
	
	
	/**EXEMPLE:
	 * add(1)-->O(1)
	 * add(2)-->O(1)
	 * remove()-->O(n)
	 * remove()-->O(1)
	 * add(1)-->O(n)
	 * add(2)-->O(1)
	 */
	
	public My_Queue() {
		reversed = 0;
	}
	
	public void add(T d) {
		if(reversed == 1) {
			//I breaked a sequence of removes
			while(s2.peek() != null) {
				s1.push(s2.pop());
			}
		}
		s1.push(d);
		reversed = 0;
	}
	
	public T remove() {
		
		if(reversed == 0) {
			//I breakead a sequence of adds
			
			while(s2.peek() != null) {
				s2.pop();
			}

			while(s1.peek() != null) {
				s2.push(s1.pop());
			}		
		}
		T item = s2.peek();
		s2.pop();
		reversed = 1;
		return item;
		
		
		
	}

}
