package bugelli;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class ListPanel extends JPanel {
	private int diameter = 30;
	private ArrayList<ListItem> mList = new ArrayList<ListItem>();
	public Integer[] allnumbers;
	public ListPanel(String title) {
		super();
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), title));
	}

	public ListPanel(String title, ArrayList<ListItem> list) {
		this(title);
		addItems(list);
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
		repaint();
	}

	@SuppressWarnings("unchecked")
	public void addItems(ArrayList<ListItem> list) {
		mList = (ArrayList<ListItem>) list.clone();
		for (ListItem item : mList)
			add(new JLabel(item.createIcon(diameter)));
	}
}