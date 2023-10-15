package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearch implements ISearchAlgo {
	
	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		// TODO Auto-generated method stub
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				
				explored.add(current);
				
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					double newPathost = current.getPathCost()+child.getWeight();
					Node end = child.getEnd();
					if(!frontier.contains(end) && !explored.contains(end)) {
					frontier.add(end);
					end.setPathCost(newPathost);
					end.setParent(current);
					}else if(frontier.contains(end) && end.getPathCost()> newPathost) {
						end.setPathCost(newPathost);
						end.setParent(current);
				}
				}
					
//					Node n = child.getEnd();
//					
//					if (!frontier.contains(child) && !explored.contains(child)) {
//						frontier.add(n);
//						
//					}else if(n.getPathCost()>current.getPathCost())
//						n.setPathCost(current.getPathCost()+child.getBegin().getPathCost());
//						n.setParent(current);
//				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		frontier.add(root);
		boolean visit = false;
		while (!frontier.isEmpty()) {
			Node curr = frontier.poll();
			if (curr.getLabel().equals(start)) {
				visit = true;
				frontier.clear();
				curr.setParent(null);
				curr.setPathCost(0);
				return execute(curr, goal);
			}else {
				List<Edge> children = curr.getChildren();
				for (Edge child : children) {
					Node childNode = child.getEnd();
					childNode.setPathCost(child.getWeight()+curr.getPathCost());
					childNode.setParent(curr);
					frontier.add(childNode);
				}
			}
		}
		return null;
	}

}
