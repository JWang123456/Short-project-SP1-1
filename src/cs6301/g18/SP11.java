package cs6301.g18;


import java.util.*;
public class SP11 {
	public int[] arr;
	public Integer[] iarr;
	public int[] tmp;
	public Integer[] itmp;
	
	public SP11(int size){
		this.arr = new int[size];
		this.iarr = new Integer[size];
		this.tmp = new int[size];
		this.itmp = new Integer[size];
		Random rand = new Random();
		for(int i = 0;i < size;i ++){
			arr[i] = rand.nextInt(size*10);
		}
		for(int i = 0;i < size;i ++){
			iarr[i] = new Integer(rand.nextInt(size*10));
		}
	}

	
	static void mergeSort(int[] arr, int[] tmp){
		
		int high = arr.length-1;
		int low = 0;
		sort(arr, tmp, low, high);
	}
	static private void sort(int[] arr, int[] tmp, int low, int high){
		if(low >= high) return;
		
			int mid = (low+high)/2;
			sort(arr, tmp, low,mid);
			sort(arr, tmp, mid+1,high);
			merge(arr,tmp,low,mid,high);

	}
	static private void merge(int[]arr, int[]tmp, int low, int mid, int high){
		int ml = low;
		int mr = mid+1;
		int i = low;
		int j = low;
		
	
		while(ml <= mid && mr <= high){
			if(arr[ml]<arr[mr]){
				tmp[i++] = arr[ml++];
			}
			else{
				tmp[i++] = arr[mr++];
			}
			
		}
		while(ml <= mid){
			tmp[i++] = arr[ml++];
		}
		while(mr <= high){
			tmp[i++] = arr[mr++];
		}
		while(j<=high){
			arr[j] = tmp[j];
			j++;
		}
		
	}
	static <T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp){
		
		int high = arr.length-1;
		int low = 0;
		sort(arr, tmp, low, high);
		
	}
	static private<T extends Comparable<? super T>> void sort(T[] arr, T[] tmp, int low, int high){
		if(low>=high)return;
		
		int mid = (low+high)/2;
		sort(arr, tmp, low,mid);
		sort(arr, tmp, mid+1,high);
		merge(arr,tmp,low,mid,high);
		
	}
	static private<T extends Comparable<? super T>> void merge(T[]arr, T[]tmp, int low, int mid, int high){
		int ml = low;
		int mr = mid+1;
		int i = low;
		int j = low;
		
		while(ml <= mid && mr <= high){
			if(arr[ml].compareTo(arr[mr]) < 0){
				tmp[i++] = arr[ml++];
			}
			else{
				tmp[i++] = arr[mr++];
			}
			
		}
		while(ml <= mid){
			tmp[i++] = arr[ml++];
		}
		while(mr <= high){
			tmp[i++] = arr[mr++];
		}
		while(j <= high){
			arr[j] = tmp[j];
			j++;
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
	public static void main(String args[]){
		
		SP11 first = new SP11((int)Math.pow(2, 20));
		//Here is a test to see if the nSquareSort function is right or wrong.
		/*Integer[] w = new Integer[8];
		w[0] = new Integer(8);
		w[1] = new Integer(7);
		w[2] = new Integer(6);
		w[3] = new Integer(5);
		w[4] = new Integer(4);
		w[5] = new Integer(3);
		w[6] = new Integer(2);
		w[7] = new Integer(1);
		first.nSquareSort(w);
		System.out.println(w[0]);
		System.out.println(w[1]);
		System.out.println(w[2]);
		System.out.println(w[3]);
		System.out.println(w[4]);
		System.out.println(w[5]);
		System.out.println(w[6]);
		System.out.println(w[7]);*/
		
		Timer timer = new Timer();
		first.mergeSort(first.arr, first.tmp);
		System.out.println(timer.end());
		
	
		
		timer.start();
		first.mergeSort(first.iarr, first.itmp);
		System.out.println(timer.end());
		
	
		SP11 second = new SP11((int)Math.pow(2, 24));
		timer.start();
		second.mergeSort(second.arr, second.tmp);
		System.out.println(timer.end());
		
		timer.start();
		second.mergeSort(second.iarr, second.itmp);
		System.out.println(timer.end());
		
		SP11 third = new SP11((int)Math.pow(2, 20));
		timer.start();
		third.nSquareSort(third.iarr);
		System.out.println(timer.end());
		
		
		
		
		
	}
}
