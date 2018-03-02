
package view;

import java.util.List;
import java.util.Scanner;

import controller.GalleryItemHelper;
import model.GalleryItem;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static GalleryItemHelper lih = new GalleryItemHelper();

	private static void addAnItem() {
		System.out.print("Enter the title of the artwork: ");
		String title = in.nextLine();
		System.out.print("Enter the artist's name: ");
		String artistName = in.nextLine();
		System.out.print("Enter the media type: ");
		String media = in.nextLine();
		System.out.print("Enter the year created: ");
		String year = in.nextLine();
		System.out.print("Enter the value of the artwork: ");
		Double value = in.nextDouble();

		GalleryItem toAdd = new GalleryItem(title, artistName, media, year, value);
		lih.insertItem(toAdd);

	}

	private static void deleteAnItem() {
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

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our Art Gallery. ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Delete an item");
			System.out.println("*  3 -- View the list");
			System.out.println("*  4 -- Exit. Thank-you for making your updates. ");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			}

			else if (selection == 2) {
				deleteAnItem();
			} else if (selection == 3) {
				viewTheList();
			} else {
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<GalleryItem> allItems = lih.showAllItems();

		for (GalleryItem li : allItems) {
			System.out.println(li.returnGalleryItemDetails());
		}
	}

}
