package com.maxgain.code;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.maxgain.code.util.Pair;




public class MaxGainsTest {

	private MaxGainCalculator maxGainCalc = null;
	private List<Tick> ticks = null;

	@Before
	public void setUp() {
		maxGainCalc = new MaxGainCalculator();
		ticks = new ArrayList<Tick>();
	}

	@Test
	public void wrongPrice() {
		ticks.add(new Tick(0, 0));
		assertEquals(0, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculateDesc() {
		for (int i = 0; i < 24; i++) {
			ticks.add(new Tick(i, 1 + i));
		}
		assertEquals(23, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculateDescWithTiming() {
		for (int i = 0; i < 24; i++) {
			ticks.add(new Tick(i, 1 + i));
			// ticks.add(new Tick(i,Math.abs(new
			// SecureRandom().nextInt(1000))));
		}
		Pair<Tick, Tick> pair = maxGainCalc.maxGainWithTiming(ticks);
		assertEquals(0, pair.getA().getTime());
		assertEquals(1, pair.getA().getPrice());
		assertEquals(23, pair.getB().getTime());
		assertEquals(24, pair.getB().getPrice());
	}

	@Test
	public void calculateAscend() {
		for (int i = 0; i < 24; i++) {
			ticks.add(new Tick(i, 24 - i));
		}
		assertEquals(0, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculateEasy() {
		ticks.add(new Tick(0, 10));
		ticks.add(new Tick(1, 15));
		ticks.add(new Tick(2, 12));
		ticks.add(new Tick(3, 11));
		ticks.add(new Tick(4, 13));
		assertEquals(5, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculateEasyWithTiming() {
		ticks.add(new Tick(0, 10));
		ticks.add(new Tick(1, 15));
		ticks.add(new Tick(2, 12));
		ticks.add(new Tick(3, 11));
		ticks.add(new Tick(4, 13));
		Pair<Tick, Tick> pair = maxGainCalc.maxGainWithTiming(ticks);
		assertEquals(0, pair.getA().getTime());
		assertEquals(10, pair.getA().getPrice());
		assertEquals(1, pair.getB().getTime());
		assertEquals(15, pair.getB().getPrice());
	}

	@Test
	public void calculate15Tick() {
		ticks.add(new Tick(0, 90));
		ticks.add(new Tick(1, 75));
		ticks.add(new Tick(2, 50));
		ticks.add(new Tick(3, 61));
		ticks.add(new Tick(4, 53));
		ticks.add(new Tick(5, 50));
		ticks.add(new Tick(6, 37));
		ticks.add(new Tick(7, 52));
		ticks.add(new Tick(8, 41));
		ticks.add(new Tick(9, 343));
		ticks.add(new Tick(10, 32));
		ticks.add(new Tick(11, 75));
		ticks.add(new Tick(12, 82));
		ticks.add(new Tick(13, 32));
		ticks.add(new Tick(14, 1143));
		assertEquals(1111, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculate15TickWithTiming() {
		ticks.add(new Tick(0, 90));
		ticks.add(new Tick(1, 75));
		ticks.add(new Tick(2, 50));
		ticks.add(new Tick(3, 61));
		ticks.add(new Tick(4, 53));
		ticks.add(new Tick(5, 50));
		ticks.add(new Tick(6, 37));
		ticks.add(new Tick(7, 52));
		ticks.add(new Tick(8, 41));
		ticks.add(new Tick(9, 343));
		ticks.add(new Tick(10, 32));
		ticks.add(new Tick(11, 75));
		ticks.add(new Tick(12, 82));
		ticks.add(new Tick(13, 32));
		ticks.add(new Tick(14, 1143));
		Pair<Tick, Tick> pair = maxGainCalc.maxGainWithTiming(ticks);
		assertEquals(10, pair.getA().getTime());
		assertEquals(32, pair.getA().getPrice());
		assertEquals(14, pair.getB().getTime());
		assertEquals(1143, pair.getB().getPrice());
	}

	@Test
	public void calculateEasy3() {
		ticks.add(new Tick(0, 15));
		ticks.add(new Tick(1, 12));
		ticks.add(new Tick(2, 11));
		ticks.add(new Tick(3, 13));
		ticks.add(new Tick(4, 15));
		assertEquals(4, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculateEasy3WithTiming() {
		ticks.add(new Tick(0, 15));
		ticks.add(new Tick(1, 12));
		ticks.add(new Tick(2, 11));
		ticks.add(new Tick(3, 13));
		ticks.add(new Tick(4, 15));
		Pair<Tick, Tick> pair = maxGainCalc.maxGainWithTiming(ticks);
		assertEquals(2, pair.getA().getTime());
		assertEquals(11, pair.getA().getPrice());
		assertEquals(4, pair.getB().getTime());
		assertEquals(15, pair.getB().getPrice());
	}

	@Test
	public void calculateEasy2() {
		ticks.add(new Tick(0, 15));
		ticks.add(new Tick(1, 16));
		ticks.add(new Tick(2, 12));
		ticks.add(new Tick(3, 11));
		ticks.add(new Tick(4, 13));
		assertEquals(2, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculateEasy2WithTiming() {
		ticks.add(new Tick(0, 15));
		ticks.add(new Tick(1, 16));
		ticks.add(new Tick(2, 12));
		ticks.add(new Tick(3, 11));
		ticks.add(new Tick(4, 13));
		assertEquals(2, maxGainCalc.maxGain(ticks));
		Pair<Tick, Tick> pair = maxGainCalc.maxGainWithTiming(ticks);
		assertEquals(3, pair.getA().getTime());
		assertEquals(11, pair.getA().getPrice());
		assertEquals(4, pair.getB().getTime());
		assertEquals(13, pair.getB().getPrice());
	}

	@Test
	public void calculateDuringFlatMarket() {
		ticks.add(new Tick(0, 15));
		ticks.add(new Tick(1, 15));
		ticks.add(new Tick(2, 12));
		ticks.add(new Tick(3, 11));
		ticks.add(new Tick(4, 13));
		assertEquals(2, maxGainCalc.maxGain(ticks));
	}

	@Test
	public void calculateDuringFlatMarketWithTiming() {
		ticks.add(new Tick(0, 15));
		ticks.add(new Tick(1, 15));
		ticks.add(new Tick(2, 12));
		ticks.add(new Tick(3, 11));
		ticks.add(new Tick(4, 13));
		assertEquals(2, maxGainCalc.maxGain(ticks));
		Pair<Tick, Tick> pair = maxGainCalc.maxGainWithTiming(ticks);
		assertEquals(3, pair.getA().getTime());
		assertEquals(11, pair.getA().getPrice());
		assertEquals(4, pair.getB().getTime());
		assertEquals(13, pair.getB().getPrice());
	}

}
