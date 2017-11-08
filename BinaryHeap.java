import java.lang.reflect.Array;


public class BinaryHeap {
	private int [] heap;
	private int size;
	
	public BinaryHeap(){
		heap = new int [10];
		heap[0] = Integer.MIN_VALUE;
		size = 0;
	}
	private int leftChild(int pos) {
		return 2 * pos;
	}

	
	private int parent(int pos) {
		return pos / 2;
	}

	private boolean isLeaf(int pos) {
		return ((pos > size / 2) && (pos <= size));
	}

	private void swap(int pos1, int pos2) {
		int tmp;
		tmp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = tmp;
	}

	/** Insert an element into the heap */
	public void add(int elem) {
		if(size>=heap.length-1){
			grow();
		}
		size++;
		heap[size] = elem;
		
		int current = size;
		while (heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
			}
		}
	
	public int remove() {
		swap(1, size); 
		size--;  	      
		if (size != 0)
			pushdown(1);
		return heap[size + 1];
	}
	private void pushdown(int position) {
		int smallestchild;
		while (!isLeaf(position)) {
		        smallestchild = leftChild(position);
			if ((smallestchild < size) && (heap[smallestchild] > heap[smallestchild + 1]))
				smallestchild = smallestchild + 1; 
			if (heap[position] <=heap[smallestchild]) {
				return;
			}
			swap(position, smallestchild);
			position = smallestchild;
		}
	}

	
	private void grow(){
		int[] tempA = new int[heap.length*heap.length];
		System.arraycopy(heap,0, tempA, 0, heap.length);
		heap = tempA;
	}
}
