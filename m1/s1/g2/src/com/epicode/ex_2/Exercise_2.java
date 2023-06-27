package com.epicode.ex_2;

public class Exercise_2 {

	public static void main(String[] args) {
		SIM newSim = new SIM("333666999");
		newSim.recharge(5.00);
		newSim.doCall(1.28, "33300011199");
		newSim.doCall(0.56, "33300011199");
		newSim.doCall(3.11, "33300011199");
		newSim.showDetails();
	}

}
