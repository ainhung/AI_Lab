package k21;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		int re = Double.compare(n1.getPathCost(), n2.getPathCost());
		if(re == 0)
			return n1.getLabel().compareTo(n2.getLabel());
		else
			return re;
	}
}
