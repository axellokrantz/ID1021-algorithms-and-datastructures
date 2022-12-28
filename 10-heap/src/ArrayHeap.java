class ArrayHeap {
    public static void main(String[] args) {
      Heap queue = new Heap(6);
      queue.bubble(6);
      queue.bubble(1);
      queue.bubble(3);
      queue.bubble(8);
      queue.bubble(5);
      queue.bubble(9);
  
      queue.print();
  
      queue.remove();
      System.out.println();
      queue.print();
    }
  
    public static class Heap {
      private int[] queue;
      private int k;
  
      public Heap(int capacity) {
        queue = new int[capacity];
        k = 0;
      }
  
      private int parent(int position) {
        return queue[parentIndex(position)];
      }
  
      private int parentIndex(int position) {
        if(position == 0) {
          return 0;
        }
        
        if((position % 2) == 0) {
          return (position - 2) / 2;
        } else {
          return (position - 1) / 2;
        }
      }
  
      //Om index av vänster och höger barn är större än k, finns det inte eftersom k pekar på sista elementet i listan
      private boolean isLeaf(int position) {
        return rightChildIndex(position) >= k || leftChildIndex(position) >= k;
      }
  
      private int leftChild(int position) {
        return queue[leftChildIndex(position)];
      }
  
      private int leftChildIndex(int position) {
        return 2 * position + 1;
      }
  
      private int rightChild(int position) {
        return queue[rightChildIndex(position)];
      }
  
      private int rightChildIndex(int position) {
        return 2 * position + 2;
      }
  
      private void swap(int pos1, int pos2) {
        int tmp = queue[pos1];
        queue[pos1] = queue[pos2];
        queue[pos2] = tmp;
      }
  
      private void bubble(int priority) {
        queue[k++] = priority;
        int pivot = k-1;
  
        while(queue[pivot] < parent(pivot)) {
          swap(pivot, parentIndex(pivot));
          pivot = parentIndex(pivot);
        }
      }
  
      public void print() {
        for(int i = 0; i < (k/2); i++) {
          System.out.print("Parent : " + queue[i]);
          if(leftChildIndex(i) < k) {
            System.out.print("Left : " + queue[leftChildIndex(i)]);
          }
          if(rightChildIndex(i) < k) {
            System.out.print("Right : " + queue[rightChildIndex(i)]);
          }
          System.out.println();
        }
      }
  
      public int remove() {
        int removedElement = queue[0];
        queue[0] = queue[--k];
        sink(0);
        return removedElement;
      }
  
      private void sink (int pivot) {
  
        // Rekursivt anrop av sink så länge pivot inte är en leaf
        if(!isLeaf(pivot)) {
          if(queue[pivot] > leftChild(pivot) || queue[pivot] > rightChild(pivot)) {
            if(leftChild(pivot) < rightChild(pivot)) {
              swap(pivot, leftChildIndex(pivot));
              sink(leftChildIndex(pivot));
            } else {
              swap(pivot, rightChildIndex(pivot));
              sink(rightChildIndex(pivot));
            }
          }
        }
      }
    }
  }
  