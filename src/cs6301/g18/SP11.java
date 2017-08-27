package cs6301.g18;

public class SP11 {
	
	public SP11(){
		
	}
	static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp){
		int high = arr.length-1;
		int low = 0;
		sort(arr, tmp, low, high);
	}
	
	static void mergeSort(int[] arr, int[] tmp){
		int high = arr.length-1;
		int low = 0;
		Integer arrI[] = new Integer[arr.length];
		Integer tmpI[] = new Integer[tmp.length];
		for(int i = 0;i < arr.length;i ++){
			arrI[i] = arr[i];
		}
		for(int i = 0;i < arr.length;i ++){
			tmp[i] = tmp[i];
		}
		sort(arrI, tmpI, low, high);
	}
	static private<T extends Comparable<? super T>> void sort(T[] arr, T[] tmp, int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			sort(arr, tmp, low,mid);
			sort(arr, tmp, mid+1,high);
			merge(arr,tmp,low,mid,high);
		}
	}
	static private<T extends Comparable<? super T>> void merge(T[]arr, T[]tmp, int low, int mid, int high){
		int ml = low;
		int mr = mid+1;
		int i = low;
		
		while(ml < low && mr<high){
			if(arr[ml].compareTo(arr[mr]) < 0){
				tmp[i++] = arr[ml++];
			}
			if(arr[ml].compareTo(arr[mr]) >= 0){
				tmp[i++] = arr[mr++];
			}
			
		}
		while(ml < low){
			tmp[i++] = arr[ml++];
		}
		while(mr < high){
			tmp[i++] = arr[mr++];
		}
	}
	static<T extends Comparable<? super T>> void nSquareSort(T[] arr){
		
        for (int i=0 ; i<arr.length ; i++)
        {
            T key = arr[i];
            int j = i-1;
 
            
            while (j>=0 && (arr[j].compareTo(key) > 0))
            {
                arr[j+1] = arr[j--];
            }
            arr[j+1] = key;
        }
	}
}
