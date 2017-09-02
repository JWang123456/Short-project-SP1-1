package cs6301.g18;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class MergeSortTest {
	
	static String content = "MergerSort Integer: " + "\n";

	public void sort() throws InterruptedException, ExecutionException {
		for(int p = 1; p <= 16 ; p = p + 3) {
			   //MergeSort General type: Integer
				Integer[] arr1 = new Integer[(int) Math.pow(2, 20) * p];
			   for(int i = 0; i < arr1.length; i++) {
				   arr1[i] = (int) (Math.random() * Math.pow(2, 0) * p);
			   }
			   Integer[] tmp = new Integer[arr1.length];
			   Shuffle.shuffle(arr1, 0, arr1.length - 1);
			   Timer timer1 = new Timer();
			   Task task = new Task(arr1, tmp, timer1);
			   FutureTask<String> futureTask = new FutureTask<>(task);
			   ExecutorService executor = Executors.newFixedThreadPool(1);
			   executor.execute(futureTask);
			   while (true) {
				   String s = null;
					try {
						s = futureTask.get(120 * 1000, TimeUnit.MILLISECONDS);
					} catch (TimeoutException e) {
						// TODO Auto-generated catch block
						content += p + "M: " + "Time Exceeded" + "\n";
						break;
					}
					content += p + "M: " + timer1.toString() + "\n";
					break;
			   }
		   }
		content += "\n" + "MergerSort int: " + "\n";
		   for(int p = 1; p <= 16 ; p = p + 3) {
			   //MergeSort int type
			   int[] arr3 = new int[(int) Math.pow(2, 20) * p];
			   for(int i = 0; i < arr3.length; i++) {
				   arr3[i] = (int) (Math.random() * Math.pow(2, 20) * p);
			   }
			   int[] tmp3 = new int[arr3.length];
			   Timer timer3 = new Timer();
			   Task_p task = new Task_p (arr3, tmp3, timer3);
			   FutureTask<String> futureTask = new FutureTask<>(task);
			   ExecutorService executor = Executors.newFixedThreadPool(1);
			   executor.execute(futureTask);
			   while (true) {
				   String s = null;
					try {
						s = futureTask.get(120 * 1000, TimeUnit.MILLISECONDS);
					} catch (TimeoutException e) {
						// TODO Auto-generated catch block
						content += p + "M: " + "Time Exceeded" + "\n";
						break;
					}
					content += p + "M: " + timer3.toString() + "\n";
					break;
			   }
		   }
		   content += "\n" + "InsertionSort Integer: " + "\n";
		   for(int p = 1; p <= 16 ; p = p + 3) {
			   
			   //InsertionSort General type: Integer
			   Integer[] arr5 = new Integer[(int) Math.pow(2, 20) * p];
			   for(int i = 0; i < arr5.length; i++) {
				   arr5[i] = (int) (Math.random() * Math.pow(2, 20) * p);
			   }
			   Shuffle.shuffle(arr5, 0, arr5.length - 1);
			   Timer timer5 = new Timer();
			   Task_i task = new Task_i (arr5, timer5);
			   FutureTask<String> futureTask = new FutureTask<>(task);
			   ExecutorService executor = Executors.newFixedThreadPool(1);
			   executor.execute(futureTask);
			   while (true) {
				   String s = null;
					try {
						s = futureTask.get(120 * 1000, TimeUnit.MILLISECONDS);
					} catch (TimeoutException e) {
						// TODO Auto-generated catch block
						content += p + "M: " + "Time Exceeded" + "\n";
						break;
					}
					content += p + "M: " + timer5.toString() + "\n";
					break;
			   }
		   }
		   
		   writeToFile();
	}
	
	public static void writeToFile() {
		final String FILENAME = "result.txt";
		   BufferedWriter bw = null;
		   FileWriter fw = null;
		   try {
			   	
				fw = new FileWriter(FILENAME);
				bw = new BufferedWriter(fw);
				bw.write(content);


			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException  {
		MergeSortTest ms = new MergeSortTest();
		ms.sort();
	}
	
	class Task implements Callable<String> {

		Integer[] arr1;
		Integer[] tmp;
		Timer timer1;
	
		public Task(Integer[] arr1, Integer[] tmp, Timer timer1) {
			this.arr1 = arr1;
			this.tmp = tmp;
			this.timer1 = timer1;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			timer1.start();
			MergeSort.mergeSort(arr1, tmp);
			timer1.end();
			return timer1.toString();

		}
		
	}
	
	class Task_p implements Callable<String> {

		int[] arr1;
		int[] tmp;
		Timer timer1;
	
		public Task_p (int[] arr1, int[] tmp, Timer timer1) {
			this.arr1 = arr1;
			this.tmp = tmp;
			this.timer1 = timer1;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			timer1.start();
			MergeSort.mergeSort(arr1, tmp);
			timer1.end();
			return timer1.toString();

		}
		
	}
	
	class Task_i implements Callable<String> {

		Integer[] arr1;
		Timer timer1;
	
		public Task_i (Integer[] arr1, Timer timer1) {
			this.arr1 = arr1;
			this.timer1 = timer1;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			timer1.start();
			MergeSort.nSquareSort(arr1);
			timer1.end();
			return timer1.toString();

		}
		
	}
		   
}
