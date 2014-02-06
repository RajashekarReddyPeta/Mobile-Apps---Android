package com.spring2014.mad;

/*Assignment :1
 Group Members
 1)Raja Shekar reddy Peta
 2)Rakesh Kumar Gopishetty
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PartOne {

	public static void main(String[] args) {
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		Set<String> set1 = new TreeSet<String>();
		Set<String> set2 = new TreeSet<String>();
		try {
			reader1 = new BufferedReader(new FileReader(new File(
					"userListOld.txt")));
			reader2 = new BufferedReader(new FileReader(new File(
					"userListNew.txt")));

			String line1 = null;
			String line2 = null;
			while ((line1 = reader1.readLine()) != null) {
				set1.add(line1);
			}
			while ((line2 = reader2.readLine()) != null) {
				set2.add(line2);
			}
			set2.removeAll(set1);
			// System.out.println(set2);
			System.out
					.println("\nTotal number of users found in the new user set : "
							+ set2.size() + "\n");
			List<String> Names = new ArrayList<String>(set2);
			Collections.sort(Names, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					String[] s1 = o1.split(",");
					String[] s2 = o2.split(",");
					return s1[3].compareTo(s2[3]);
				}
			});
			System.out
					.println("List of users After Sorting in Ascending order by age \n");
			for (String names : Names) {
				System.out.println(names);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader1 != null)
					reader1.close();
				if (reader2 != null)
					reader2.close();
			} catch (IOException excep) {
				excep.printStackTrace();
			}
		}

	}

}