package agent_ABCD_task3;

import java.util.HashMap;
import java.util.Map;

import agent_ABCD_task3.Environment.LocationState;

public class EnvironmentState {
	Map<int[][], Environment.LocationState> state = new HashMap<int[][], Environment.LocationState>();
	private int[][] agentLocation = null;//

	public EnvironmentState(LocationState[][] locationStates) {
		for (int row = 0; row < locationStates.length; row++) {
			for (int col = 0; col < locationStates[0].length; col++) {
				int location[][] = new int[row][col];
				this.state.put(location, locationStates[row][col]);
			}
		}
	}



	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}