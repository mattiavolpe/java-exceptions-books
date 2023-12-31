package org.java.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
				
				System.out.print("\n");

				books[i] = new Libro(title, pages, author, editor);
			} catch (Exception e) {
				i--;
				System.err.println("\n" + e.getMessage() + "\n");
			}
		}
		
		sc.close();
		
		File booksFile = new File("./books.txt");
		
		if (!booksFile.exists()) {
			try {
				booksFile.createNewFile();
			} catch (Exception e) {
				System.err.println("Unable to create the file \"books.txt\".\nTRY AGAIN");
				return;
			}
		}
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(booksFile);
			
			for (int i = 0; i < books.length; i++) {
				writer.write(books[i].printToFile() + "\n\n");
			}
		} catch (IOException e) {
			System.err.println("Error writing file");
		}  finally {
			try {
				writer.close();				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		Scanner reader = null;
		
		try {
			reader = new Scanner(booksFile);
			
			while (reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error reading file");
		}  finally {
			if (reader != null)
				reader.close();				
		}
	}
}
