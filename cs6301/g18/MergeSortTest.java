package cs6301.g18;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class MergeSortTest {

	@SuppressWarnings("deprecation")
	public static <T> void main(String[] args) throws FileNotFoundException, InterruptedException {

		   final String FILENAME = "result.txt";
		   BufferedWriter bw = null;
		   FileWriter fw = null;
		   try {

				String content = "";
				
				for(int p = 1; p <= 16 ; p++) {
					   
					   //MergeSort General type: Integer
					   Integer[] arr1 = new Integer[(int) Math.pow(2, 20) * p];
					   for(int i = 0; i < arr1.length; i++) {
						   arr1[i] = (int) (Math.random() * Math.pow(2, 0) * p);
					   }
					   Integer[] tmp = new Integer[arr1.length];
					   Shuffle.shuffle(arr1, 0, arr1.length - 1);
					   Timer timer1 = new Timer();
					   timer1.start();
					   MergeSort.mergeSort(arr1, tmp);
					   timer1.end();
					   content += "MergeSort general type: Integer " + p + "M: " + timer1.toString() + "\n";
					   
				   }
				   
				   for(int p = 1; p <= 16 ; p++) {
					   //MergeSort int type
					   int[] arr3 = new int[(int) Math.pow(2, 20) * p];
					   for(int i = 0; i < arr3.length; i++) {
						   arr3[i] = (int) (Math.random() * Math.pow(2, 20) * p);
					   }
					   int[] tmp3 = new int[arr3.length];
					   Timer timer3 = new Timer();
					   timer3.start();
					   MergeSort.mergeSort(arr3, tmp3);
					   timer3.end();
					   content += "MergeSort primitive type: int" + p + "M: " + timer3.toString() + "\n";
				   }
				   
				   for(int p = 1; p <= 16 ; p++) {
					   
					   //InsertionSort General type: Integer
					   Integer[] arr5 = new Integer[(int) Math.pow(2, 20) * p];
					   for(int i = 0; i < arr5.length; i++) {
						   arr5[i] = (int) (Math.random() * Math.pow(2, 20) * p);
					   }
					   Shuffle.shuffle(arr5, 0, arr5.length - 1);
					   Timer timer5 = new Timer();
					   Timer timer6 = new Timer();
					   Thread sort = new Thread(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								timer5.start();
								MergeSort.nSquareSort(arr5);
								timer5.end();
							}
					   });
					   sort.start();
					   Thread timeout = new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								timer6.start();
								try {
									Thread.sleep(1000 * 120);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								timer6.end();
							}
						   
					   });
					   timeout.start();
					   while(!sort.isAlive()) {
						   if(!timeout.isAlive()) break;
					   }
					  
					   content += "InsertionSort general type: Integer " + p + "M: " + timer5.toString() + "\n";
					   
				   }
				

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
		   
	   

}
