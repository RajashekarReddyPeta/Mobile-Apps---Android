package com.spring2014.mad;

/*Assignment :1
 Group Members
 1)Raja Shekar reddy Peta
 2)Rakesh Kumar Gopishetty
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Vehicle {
	private String model_year;
	private String manufacturer_name;
	private String model_name;
	private String horse_power;
	private String no_cylinders;
	private String no_gears;

	public Vehicle(String model_year, String manufacturer_name,
			String model_name, String horse_power, String no_cylinders,
			String no_gears) {
		super();
		this.model_year = model_year;
		this.manufacturer_name = manufacturer_name;
		this.model_name = model_name;
		this.horse_power = horse_power;
		this.no_cylinders = no_cylinders;
		this.no_gears = no_gears;

	}

	public String getModel_year() {
		return model_year;
	}

	public void setModel_year(String model_year) {
		this.model_year = model_year;
	}

	public String getManufacturer_name() {
		return manufacturer_name;
	}

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((horse_power == null) ? 0 : horse_power.hashCode());
		result = prime
				* result
				+ ((manufacturer_name == null) ? 0 : manufacturer_name
						.hashCode());
		result = prime * result
				+ ((model_name == null) ? 0 : model_name.hashCode());
		result = prime * result
				+ ((model_year == null) ? 0 : model_year.hashCode());
		result = prime * result
				+ ((no_cylinders == null) ? 0 : no_cylinders.hashCode());
		result = prime * result
				+ ((no_gears == null) ? 0 : no_gears.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (horse_power == null) {
			if (other.horse_power != null)
				return false;
		} else if (!horse_power.equals(other.horse_power))
			return false;
		if (manufacturer_name == null) {
			if (other.manufacturer_name != null)
				return false;
		} else if (!manufacturer_name.equals(other.manufacturer_name))
			return false;
		if (model_name == null) {
			if (other.model_name != null)
				return false;
		} else if (!model_name.equals(other.model_name))
			return false;
		if (model_year == null) {
			if (other.model_year != null)
				return false;
		} else if (!model_year.equals(other.model_year))
			return false;
		if (no_cylinders == null) {
			if (other.no_cylinders != null)
				return false;
		} else if (!no_cylinders.equals(other.no_cylinders))
			return false;
		if (no_gears == null) {
			if (other.no_gears != null)
				return false;
		} else if (!no_gears.equals(other.no_gears))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return model_year + "," + manufacturer_name + "," + model_name + ","
				+ horse_power + "," + no_cylinders + "," + no_gears;

	}
}

public class PartTwo {
	private static int c = 0;
	private static int Total = 0;

	public static void main(String[] args) {

		BufferedReader reader = null;
		BufferedWriter bw = null;
		List<Vehicle> list = new LinkedList<Vehicle>();
		List<Vehicle> distinctList;
		ArrayList<Entry<String, Integer>> sortList;
		try {
			reader = new BufferedReader(
					new FileReader(new File("raw_data.csv")));
			String line1 = null;

			while ((line1 = reader.readLine()) != null) {
				String[] rt = line1.split(",");
				for (int i = 0; i < rt.length; i++) {
					rt[i].trim();
				}

				list.add(new Vehicle(rt[0], rt[1], rt[2], rt[3], rt[4], rt[5]));
			}
			Map<String, Integer> map = new HashMap<String, Integer>();

			distinctList = removeDuplicates(list);
			File file = new File("distinct_vehicles.csv");
			// if file does not exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			System.out.println("************Distinct List*************\n");
			for (Vehicle d : distinctList) {
				String st = d.getModel_year().toString() + ":"
						+ d.getManufacturer_name().toString();
				// assigning the last count of key to count variable
				Integer count = map.get(st);
				map.put(st, (count == null) ? 1 : count + 1);
				bw.write(d.toString());
				bw.write("\n");
			}

			for (Map.Entry<String, Integer> s : map.entrySet()) {
				System.out.println(++Total + "-" + s.getKey() + ":"
						+ s.getValue());
			}
			System.out
					.println("-------------------------------------\nTotal  : "
							+ Total + "\n-------------------------------------");
			sortList = new ArrayList<Entry<String, Integer>>(map.entrySet());
			Collections.sort(sortList,
					new Comparator<Entry<String, Integer>>() {
						@Override
						public int compare(Entry<String, Integer> st1,
								Entry<String, Integer> st2) {
							// compare the value to sort it the value in
							// descending order of value
							return -st1.getValue().compareTo(st2.getValue());
						}
					});
			System.out
					.println("\nTop 10 Models\n-------------------------------------");

			for (Entry<String, Integer> s : sortList) {
				if (c++ == 10)
					break;
				System.out.println(c + "-" + s.getKey().toString() + ":"
						+ s.getValue());
			}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException excep) {
				excep.printStackTrace();
			}
		}

	}

	public static List<Vehicle> removeDuplicates(List<Vehicle> a) {

		return new LinkedList<Vehicle>(new HashSet<Vehicle>(a));
	}

}
