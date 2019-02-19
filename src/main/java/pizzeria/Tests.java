package pizzeria;

import java.util.ArrayList;
import java.util.Collections;

public class Tests {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);list.add(5);
		list.add(7);list.add(7);
		list.add(17);list.add(9);
		
		System.out.println("avant");
		for(Integer i : list)
			System.out.println(i);
		System.out.println("mnt");
		list.removeAll(Collections.singleton(7));
		
		System.out.println("aftter");
		for(Integer i : list)
			System.out.println(i);

	}

}
