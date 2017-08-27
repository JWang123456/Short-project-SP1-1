package cs6301.g18;

public class MergeSort<T> {

	static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp) {
		   mergeSort(arr, tmp, 0, arr.length - 1);
	   }
	   
	   static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp, int left, int right) {
		   int mid = (left + right) / 2;
		   if(right <= left) return;
		   mergeSort(arr, tmp, left, mid);
		   mergeSort(arr, tmp, mid + 1, right);
		   merge(arr, tmp, left, mid, right);
	   }
	   
	   @SuppressWarnings("unchecked")
	static<T extends Comparable<? super T>> void merge(T[] arr, T[] tmp, int left, int mid, int right) {
		   tmp = (T[])new Integer[right - left + 1];
		   for(int l = left, r = mid + 1, count = 0; count < tmp.length; count++) {
			   if(l == mid + 1) {
				   tmp[count] = arr[r++];
				   continue;
			   }
			   if(r == right + 1) {
				   tmp[count] = arr[l++];
				   continue;
			   }
			   tmp[count] = (arr[l].compareTo(arr[r]) < 0) ? arr[l++] : arr[r++];
		   }
		   for(int k = 0; k < tmp.length; k++) {
			   arr[k + left] = tmp[k];
		   }
	   }
	   
	   static void mergeSort(int[] arr, int[] tmp) {
		   mergeSort(arr, tmp, 0, arr.length - 1);
	   }
	   
	   static void mergeSort(int[] arr, int[] tmp, int left, int right) {
		   int mid = (left + right) / 2;
		   if(right <= left) return;
		   mergeSort(arr, tmp, left, mid);
		   mergeSort(arr, tmp, mid + 1, right);
		   merge(arr, tmp, left, mid, right);
	   }
	   
	   static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
		   tmp = new int[right - left + 1];
		   for(int l = left, r = mid + 1, count = 0; count < tmp.length; count++) {
			   if(l == mid + 1) {
				   tmp[count] = arr[r++];
				   continue;
			   }
			   if(r == right + 1) {
				   tmp[count] = arr[l++];
				   continue;
			   }
			   tmp[count] = (arr[l] < arr[r]) ? arr[l++] : arr[r++];
		   }
		   for(int k = 0; k < tmp.length; k++) {
			   arr[k + left] = tmp[k];
		   }
	   }
	   
	   static<T extends Comparable<? super T>> void nSquareSort(T[] arr) {
		   
	   }
	   
	   public static <T> void main(String[] args) {
		   
		   Integer[] arr = new Integer[] {1,3,5,7,9,2,4,6,8,10,12,14,16,18};
		   Integer[] tmp = new Integer[arr.length];
		   Shuffle.shuffle(arr, 0, arr.length - 1);
		   Shuffle.printArray(arr, "Before: ");
		   MergeSort.mergeSort(arr, tmp);
		   Shuffle.printArray(arr, "After: ");
		   
		   
	   }
}
