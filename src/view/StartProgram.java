package view;

import java.util.List;
import java.util.Scanner;
import controller.GalleryItemHelper;
import model.GalleryItem;


public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static GalleryItemHelper lih = new GalleryItemHelper();

	private static void addAnItem() {
		
		System.out.print("Enter the title of this piece of art: ");
		String title = in.nextLine();
		System.out.print("Enter the artist's name: ");
		String artistName = in.nextLine();
		System.out.print("Enter the media of this art: ");
		String media = in.nextLine();
		System.out.print("Enter the year this artwork was created: ");
		String year = in.nextLine();
		System.out.print("Enter the monetary value of this artwork: $");
		Double value = in.nextDouble();
		//in.nextLine();				
		
		GalleryItem toAdd = new GalleryItem(title, artistName, media, year, value);
		lih.insertItem(toAdd);
	}		
	
	
	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the title to delete: ");
		String title = in.nextLine();
		System.out.print("Enter the artist name to delete: ");
		String artistName = in.nextLine();
		System.out.print("Enter the media to delete: ");
		String media = in.nextLine();
		System.out.print("Enter the year to delete: ");
		String year = in.nextLine();
		System.out.print("Enter the value to delete: ");
		Double value = in.nextDouble();

		GalleryItem toDelete = new GalleryItem(title, artistName, media, year, value);
		lih.deleteItem(toDelete);
	}

	public static void main(String[] args) {

		runMenu();

		}
		private static void viewTheList() {
			List<GalleryItem> allItems = lih.showAllItems();
			for(GalleryItem li: allItems) {
				System.out.println(li.returnArtworkDetails());
			}
		}
			

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Rhodes Art Gallery! ---");
			while (goAgain) {
				System.out.println("*  Select a task:");
				System.out.println("*  1 -- Add new artwork");
				System.out.println("*  2 -- Remove a piece of art from the collection");
				System.out.println("*  3 -- View the list of available artwork");
				System.out.println("*  4 -- Exit");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					deleteAnItem();
				} else if (selection == 3) {
					viewTheList();
				} else {
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}
		}
		}

		

		

		

	

		

