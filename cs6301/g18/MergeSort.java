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
		   Object[] temp = new Object[right - left + 1];
		   for(int l = left, r = mid + 1, count = 0; count < temp.length; count++) {
			   if(l == mid + 1) {
				   temp[count] = arr[r++];
				   continue;
			   }
			   if(r == right + 1) {
				   temp[count] = arr[l++];
				   continue;
			   }
			   temp[count] = (arr[l].compareTo(arr[r]) < 0) ? arr[l++] : arr[r++];
		   }
		   for(int k = 0; k < temp.length; k++) {
			   arr[k + left] = (T) temp[k];
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
		   for(int i = 1; i < arr.length; i++) {
			   T insert = arr[i];
			   int j = i - 1;
			   for(j = i - 1; j >= 0 && insert.compareTo(arr[j]) < 0; j--) {
				   arr[j + 1] = arr[j];
			   }
			   arr[j + 1] = (T) insert;
		   }
	   }
	   
}
