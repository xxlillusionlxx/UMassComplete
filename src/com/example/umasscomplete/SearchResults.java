package com.example.umasscomplete;

public class SearchResults {
	 private String name = "";
	 private String storeHours = "";
	 private String phone = "";
	 private String storeHoursTwo = "";
	 
	 public void setName(String name) {
	  this.name = name;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setStoreHours(String storeHours) {
	  this.storeHours = storeHours;
	 }
	 
	 public void setStoreHoursTwo(String hours) {
		 this.storeHoursTwo = hours;
	 }

	 public String getStoreHours() {
	  return storeHours;
	 }
	 
	 public String getStoreHoursTwo() {
		 return storeHoursTwo;
	 }

	 public void setPhone(String phone) {
	  this.phone = phone;
	 }

	 public String getPhone() {
	  return phone;
	 }
}