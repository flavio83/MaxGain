package com.maxgain.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class SumGains {
	
	private Tick buy;
	private Tick sell;

	public SumGains() {
		buy = null;
		sell = null;
	}
	
	public int sumGains(List<Tick> lTicks) {
		List<Tick> asc = new ArrayList<Tick>(lTicks);
		List<Tick> desc = new ArrayList<Tick>(lTicks);
		Collections.sort(asc);
		Collections.sort(desc, Collections.reverseOrder()); 
		for(int i=0;i<lTicks.size();i++) {
			if(asc.get(i).getPrice()<1 && desc.get(i).getPrice()<1) {
				System.out.println("price less then 1 not allowed");
				return -1;
			}
			Tick ascTick = asc.get(i);
			Tick descTick = desc.get(i);
			int gain = ascTick.getPrice()-descTick.getPrice();
			if(descTick.getTime()<ascTick.getTime() && gain>0) {
				if(buy==null && sell==null) {
					buy = descTick;
					sell = ascTick;
				} else {
					if(gain>(sell.getPrice()-buy.getPrice())) {
						buy = descTick;
						sell = ascTick;
					}
				}
			}
		}
		if(buy!=null && sell!=null) {
			System.out.println("buy on time " + buy.getTime() + " at price " + buy.getPrice() 
					+ " and then sell at time " + sell.getTime() + " at price " + sell.getPrice());
			//return new Pair<Tick>(buy,sell);
			return sell.getPrice()-buy.getPrice();
		} else {
			System.out.println("Any possible gain in long position with such kind of timeserie");
			return -1;
		}
	}
	
	public static void main(String[] args) {
		new SumGains();
	}

}

class Tick implements Comparable<Tick> {
	
	private int time;
	private int price;
	
	public Tick(int time, int price) {
		this.time = time;
		this.price = price;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int compareTo(Tick tick) {
	    return this.getPrice()-tick.getPrice();
	}
}
