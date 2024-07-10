package com.training;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.training.entity.Tshirt;
import com.training.enums.Gender;
import com.training.enums.OutputPreference;
import com.training.enums.Size;
import com.training.utils.Addfiles;
import com.opencsv.bean.CsvToBeanBuilder;

public class Main extends Thread {



	/* User Input variable */
	String colour = null;
	Size size = null;
	Gender gender = null;
	OutputPreference outputpref = null;

	/* List to store T-shirt data */
	List<Tshirt> tshirtsdata = Collections.synchronizedList(new ArrayList<Tshirt>());

	/* Result List */
	List<Tshirt> result = Collections.synchronizedList(new ArrayList<Tshirt>());

	/* List of file path */
	List<Path> path = Collections.synchronizedList(new ArrayList<Path>());

	@Override
	public void run() {

		/*
		 * Create new thread and add all files to program after 15-min from resources
		 * folder
		 */

		while (true) {
			System.out.println("Loading file with new Thread");
			Addfiles newfiles = new Addfiles();
			try {

				/* Addfiles class add files path to path list */
				path = newfiles.addfiles();

			} catch (IOException e) {
				e.printStackTrace();
			}

			/* crating list from csv file */

			for (Path temp : path) {
				this.csvtolist(temp.toString());
			}

			try {
				Thread.sleep(15 * 60 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		Main tshirtobj = new Main();

		/* new thread for adding csv file to program */
		tshirtobj.start();

		Scanner input = new Scanner(System.in);
		boolean flag = true;

		while (flag == true) {

			while (tshirtobj.colour == null || tshirtobj.size == null || tshirtobj.gender == null
					|| tshirtobj.outputpref == null) {

				try {

					System.out.println("Please enter details ");
					System.out.print("Colour of Tshirt : ");
					tshirtobj.colour = input.nextLine();
					System.out.print("Enter Size (S, M, L, XL, XXL) : ");
					tshirtobj.size = Size.valueOf(input.nextLine().toUpperCase());
					System.out.print("Enter Gender (M,F) : ");
					tshirtobj.gender = Gender.valueOf(input.nextLine().toUpperCase());
					System.out.print("Sort by Price || Sort by Rating || Sort by Both : ");
					tshirtobj.outputpref = OutputPreference.valueOf(input.nextLine().toUpperCase());

				} catch (IllegalArgumentException e) {
					System.out.println("Not Valid option");

				} catch (Exception e) {
					System.out.println(e + "Not valid option");
				}
			}

			/* search for user input */
			tshirtobj.search();

			if (tshirtobj.result.size() == 0) {
				System.out.print("Nothing Found...");
			} else {
				/* sort result according to user preference */
				tshirtobj.sort(tshirtobj.result);
				tshirtobj.printlist(tshirtobj.result);
			}

			try {
				System.out.println("Do you want to Continue (Y/N) : ");
				String temp = input.nextLine();
				if (temp.equalsIgnoreCase("N")) {
					flag = false;
				}
			} catch (Exception e) {
				System.out.print(e);
			}

			tshirtobj.colour = null;
			tshirtobj.size = null;
			tshirtobj.gender = null;
			tshirtobj.outputpref = null;
			tshirtobj.result.clear();

		}

		System.out.print("ThankU");
		input.close();
		return;

	}

	public void search() {

		/* search user input from T-shirts data list and adding it to result list */
		for (Tshirt temp : tshirtsdata) {
			if (temp.getColour().equalsIgnoreCase(this.colour) && temp.getSize().equalsIgnoreCase(this.size.toString())
					&& (temp.getGender_recommendation().equalsIgnoreCase("U")
							|| temp.getGender_recommendation().equalsIgnoreCase(this.gender.toString())))
				result.add(temp);
		}
	}

	public void sort(List<Tshirt> result) {

		/* sort result according to user preference */
		switch (this.outputpref) {
		case PRICE:
			result.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
			break;

		case RATING:
			result.sort((o1, o2) -> o2.getRating().compareTo(o1.getRating()));
			break;

		case BOTH:
			result.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
			result.sort((o1, o2) -> o2.getRating().compareTo(o1.getRating()));
			break;

		}
	}

	@SuppressWarnings("unchecked")
	public void csvtolist(String filepath) {

		/* csv file to T-shirt object list */
		try {
			List<Tshirt> temp = new CsvToBeanBuilder(new FileReader(filepath)).withType(Tshirt.class).withSeparator('|')
					.build().parse();

			tshirtsdata.addAll(temp);
		} catch (FileNotFoundException e) {
			System.out.print(e);
		}
	}

	public void printlist(List<Tshirt> print) {
		/* print list */
		for (int i = 0; i < print.size(); i++) {
			System.out.println(print.get(i).toString());
		}

	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public OutputPreference getOutputpref() {
		return outputpref;
	}

	public void setOutputpref(OutputPreference outputpref) {
		this.outputpref = outputpref;
	}

	public List<Tshirt> getTshirtsdata() {
		return tshirtsdata;
	}

	public void setTshirtsdata(List<Tshirt> tshirtsdata) {
		this.tshirtsdata = tshirtsdata;
	}

	public List<Tshirt> getResult() {
		return result;
	}

	public void setResult(List<Tshirt> result) {
		this.result = result;
	}

	public List<Path> getPath() {
		return path;
	}

	public void setPath(List<Path> path) {
		this.path = path;
	}

}
