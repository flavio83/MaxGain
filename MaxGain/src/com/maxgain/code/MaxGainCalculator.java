package com.maxgain.code;

import java.util.List;

import com.maxgain.code.util.Pair;




public class MaxGainCalculator {
	
	private Tick buy;
	private Tick sell;

	public MaxGainCalculator() {
		buy = null;
		sell = null;
	}

	public int maxGain(List<Tick> list) {	
		Pair<Tick,Tick> pair = maxGainWithTiming(list);
		if(pair!=null) {
			return pair.getB().getPrice()-pair.getA().getPrice();
		} else {
			return 0;
		}
    }
	
	public Pair<Tick,Tick> maxGainWithTiming(List<Tick> list) {
		
		int previous = 0;
		int gain = 0;
		int indexBuy = 0; 
	    int indexSell = 0;

	    for (int i=0; i < list.size(); i++) {
	        if (list.get(i).getPrice() < list.get(previous).getPrice()) {
	            previous = i;
	        } else if (list.get(i).getPrice()-list.get(previous).getPrice() > gain) {
	            indexBuy = previous; 
	            indexSell = i;
	            gain = list.get(i).getPrice()-list.get(previous).getPrice();
	        }
	    }
	    
	    buy = list.get(indexBuy);
	    sell = list.get(indexSell);
		
		if(gain > 0) {
			System.out.println("buy on time " + buy.getTime() + " at price " + buy.getPrice() 
					+ " and then sell at time " + sell.getTime() + " at price " + sell.getPrice());
			return new Pair<Tick,Tick>(buy,sell);
		} else {
			System.out.println("Any possible gain in long position with such kind of timeserie");
			return null;
		}
	}

}

class Tick {
	
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
	
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(time);
		sBuffer.append(" ");
		sBuffer.append(price);
		return sBuffer.toString();
	}
	
}
