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
				orderedList.removeAll();
				orderedList.addItems(sortfirst(numbers, mine));
				orderedList.removeAll();
				orderedList.addItems(sort2nd(numbers, mine));  
				panel.add(orderedList);
				pack();
			}
		});

		panel.add(unorderedList);
		panel.add(sortButton);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private ArrayList<ListItem> arrayToList(Integer[] numbers, Integer[] mine) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i], mine[i]);
			list.add(item);
		}
		return list;
	}
	
	public ArrayList<ListItem> sortfirst(Integer[] numbers, Integer[] mine) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		Arrays.sort(numbers, Collections.reverseOrder());
		list = arrayToList(numbers, mine);
		return list;
	}
	public ArrayList<ListItem> sort2nd(Integer[] numbers, Integer[] mine) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		Arrays.sort(mine);
		list = arrayToList(numbers, mine);
		return list;
	}
	

}