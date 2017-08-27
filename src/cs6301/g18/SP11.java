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
	static <T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp){
		int high = arr.length-1;
		int low = 0;
		sort(arr, tmp, low, high);
	}
	
	static void mergeSort(int[] arr, int[] tmp){
		int high = arr.length-1;
		int low = 0;
		sort(arr, tmp, low, high);
	}
	static private<T extends Comparable<? super T>> void sort(int[] arr, int[] tmp, int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			sort(arr, tmp, low,mid);
			sort(arr, tmp, mid+1,high);
			merge(arr,tmp,low,mid,high);
		}
	}
	static private<T extends Comparable<? super T>> void merge(int[]arr, int[]tmp, int low, int mid, int high){
		int ml = low;
		int mr = mid+1;
		int i = low;
		
		while(ml < low && mr<high){
			if(ml<mr){
				tmp[i++] = arr[ml++];
			}
			else{
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
			else{
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
	public static void main(String args[]){
		
		SP11 first = new SP11((int)Math.pow(2, 20));
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
		
		
		SP11 forth = new SP11((int)Math.pow(2, 20));
		timer.start();
		forth.nSquareSort(forth.iarr);
		System.out.println(timer.end());
		
		
	}
}
