package com.maxgain.code;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;




public class SumGainsTest {
	
	private SumGains sumGains = null;
	private List<Tick> ticks = null;
	
	@Before
	public void setUp() {
		sumGains = new SumGains();
		ticks = new ArrayList<Tick>();
	}
	
	@Test
	public void wrongPrice() {
		ticks.add(new Tick(0,0));
		assertEquals(-1,sumGains.sumGains(ticks));
	}

	@Test
	public void calculateDesc() {
		for(int i=0;i<24;i++) {
			ticks.add(new Tick(i,1+i));
			//ticks.add(new Tick(i,Math.abs(new SecureRandom().nextInt(1000))));
		}
		assertEquals(23,sumGains.sumGains(ticks));
	}
	
	@Test
	public void calculateAscend() {
		for(int i=0;i<24;i++) {
			ticks.add(new Tick(i,24-i));
		}
		assertEquals(-1,sumGains.sumGains(ticks));
	}
	
	@Test
	public void calculateEasy() {
		ticks.add(new Tick(0,10));
		ticks.add(new Tick(1,15));
		ticks.add(new Tick(2,12));
		ticks.add(new Tick(3,11));
		ticks.add(new Tick(4,13));
		assertEquals(5,sumGains.sumGains(ticks));
	}
	
	@Test
	public void calculate15Tick() {
		ticks.add(new Tick(0,90));
		ticks.add(new Tick(1,75));
		ticks.add(new Tick(2,92));
		ticks.add(new Tick(3,61));
		ticks.add(new Tick(4,53));
		ticks.add(new Tick(5,50));
		ticks.add(new Tick(6,35));
		ticks.add(new Tick(7,32));
		ticks.add(new Tick(8,41));
		ticks.add(new Tick(9,343));
		ticks.add(new Tick(10,40));
		ticks.add(new Tick(11,75));
		ticks.add(new Tick(12,82));
		ticks.add(new Tick(13,81));
		ticks.add(new Tick(14,1143));
		assertEquals(1111,sumGains.sumGains(ticks));
	}
	
	@Test
	public void calculateEasy3() {
	   //ticks.add(new Tick(0,15));
	   ticks.add(new Tick(0,15));
	   ticks.add(new Tick(1,12));
	   ticks.add(new Tick(2,11));
	   ticks.add(new Tick(3,13));
	   ticks.add(new Tick(4,15));
	   assertEquals(4,sumGains.sumGains(ticks));
	}
	
	@Test
	public void calculateEasy2() {
	   ticks.add(new Tick(0,15));
	   ticks.add(new Tick(1,15));
	   ticks.add(new Tick(2,12));
	   ticks.add(new Tick(3,11));
	   ticks.add(new Tick(4,13));
	   assertEquals(2,sumGains.sumGains(ticks));
	}

}
