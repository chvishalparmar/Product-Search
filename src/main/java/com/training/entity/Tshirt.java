package com.training.entity;

import com.opencsv.bean.CsvBindByName;

public class Tshirt {
	@CsvBindByName
	String id;
	@CsvBindByName
	String name;
	@CsvBindByName
	String colour;
	@CsvBindByName
	String gender_recommendation;
	@CsvBindByName
	String size;
	@CsvBindByName
	Double price;
	@CsvBindByName
	Double rating;
	@CsvBindByName
	String availability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender_recommendation() {
		return gender_recommendation;
	}

	public void setGender_recommendation(String gender_recommendation) {
		this.gender_recommendation = gender_recommendation;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Tshirt [id=" + id + ", name=" + name + ", colour=" + colour + ", gender_recommendation="
				+ gender_recommendation + ", size=" + size + ", price=" + price + ", rating=" + rating
				+ ", availability=" + availability + "]";
	}

}
