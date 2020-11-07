package bugelli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DataStructsFrame extends JFrame {
	
	public DataStructsFrame(String title, Integer[] numbers, Integer[] mine) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		final ArrayList<ListItem> list = arrayToList(numbers, mine);

		final ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JButton sortButton = new JButton("Sort List");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				orderedList.addItems(sortfirst(numbers, mine)); //TASK 3: sorts first set oif numbers from high to low
				orderedList.removeAll(); //TASK 2: removeAll ensured only one copy of the items is passed
				orderedList.addItems(sort2nd(numbers, mine));  //TASK 4: sorts second set from low to high
				panel.add(orderedList);
				pack();
			}
		});
		
		
		JButton sortButton2 = new JButton("Add Your Own Values");//this button is for task 6 which is no longer due
		sortButton2.setSize(30, 10);
		sortButton2.setAlignmentX(LEFT_ALIGNMENT);

		sortButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		
		panel.add(sortButton2);
		panel.add(unorderedList);
		panel.add(sortButton);
		add(panel);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	/**
	 * Provided method to make an Integer[] into an ArrayList
	 * @param numbers Integer[] on numbers provided by T.Cornez
	 * @param mine Integer[] I made for the valB
	 * @return list ArrayList<ListItem> object array that holds both values from the two different Integer[]s
	 */
	private ArrayList<ListItem> arrayToList(Integer[] numbers, Integer[] mine) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i], mine[i]);
			list.add(item);
		}
		return list;
	}
	/**
	 * TASK 3: Sort based of valA from highest to lowest
	 * @param numbers Integer[] of the provided numbers, made it an INTEGER[] instead of an INT[] to implement the Collections library
	 * @param mine Integer[] in this method this array is never used
	 * @return list ArrayList<ListItem> of objects. The first set of objects will be integers from high to lowest value
	 */
	public ArrayList<ListItem> sortfirst(Integer[] numbers, Integer[] mine) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		Arrays.sort(numbers, Collections.reverseOrder());
		list = arrayToList(numbers, mine);
		return list;
	}
	/**
	 * TASK 4: Sort based of valA from highest to lowest
	 * @param numbers Integer[] of the provided numbers, in this method this array is never used
	 * @param mine Integer[] of integers I provided for the program, made it an INTEGER[] instead of an INT[] to implement the Collections library
	 * @return list ArrayList<ListItem> of objects. The Second set of objects will be integers from low to high values
	 */
	public ArrayList<ListItem> sort2nd(Integer[] numbers, Integer[] mine) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		Arrays.sort(mine);
		list = arrayToList(numbers, mine);
		return list;
	}
	

}