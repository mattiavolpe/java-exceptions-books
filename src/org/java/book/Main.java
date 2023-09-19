package org.java.book;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
		do {
			try {
				System.out.print("Enter the number of books: ");
				n = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				n = 0;
				System.err.println("Insert a number greater than 0");
			}
		} while (n < 1);
		
		Libro[] books = new Libro[n];
		
		for (int i = 0; i < n; i++) {
			try {
				System.out.print("Enter the title: ");
				String title = sc.nextLine();
				
				System.out.print("Enter the number of pages: ");
				int pages = Integer.valueOf(sc.nextLine());
				
				System.out.print("Enter the author: ");
				String author = sc.nextLine();
				
				System.out.print("Enter the editor: ");
				String editor = sc.nextLine();
				
				books[i] = new Libro(title, pages, author, editor);
			} catch (Exception e) {
				i--;
				System.err.println("\n" + e.getMessage() + "\n");
			}
		}
		
		sc.close();
	}
}