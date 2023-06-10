package practice;

import java.util.Scanner;

public class BubbleSort {

 public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter size of array");
	
	int size=s.nextInt();
	int [] a=new int[size];
	
	System.out.println("enter the elements ");
	for (int i = 0; i <size; i++) {
		a[i]=s.nextInt();
	}
	System.out.println("elements of array is");
	for (int i = 0; i < size; i++) {
		System.out.println(a[i]);
	}
	
	for (int i = 0; i < size-1; i++) {
		for (int j = 0; j < size-i-1; j++) {
			if(a[i]>a[j+1]) {
				int temp=a[j];
				a[i]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
	System.out.println("elements of array after sorting");
	for(int i=0;i<size;i++) {
		System.out.println(a[i]);
	}
}
}
