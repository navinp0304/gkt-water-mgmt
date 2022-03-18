package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.SlabInterval;

class SlabIntervalTest {
	List<SlabInterval> lobj;

	@BeforeEach
	void setup() {
		lobj = List.of(new SlabInterval(0.0, 500.0, 2.0), new SlabInterval(501.0, 1500.0, 3.0),
				new SlabInterval(1501.0, 3000.0, 5.0), new SlabInterval(3001.0, Double.MAX_VALUE, 8.0));
	}

	@Test
	void testSlabInterval() {
		SlabInterval obj = null;
		try {
			obj = new SlabInterval(-1.0, 1.0, 2.0);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "start < 0");
		}

		try {
			obj = new SlabInterval(1.0, -3.0, 2.0);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "end < 0");
		}

		try {
			obj = new SlabInterval(4.0, 3.0, 2.0);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "end < start");
		}

		try {
			obj = new SlabInterval(1.0, 3.0, -8.0);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "rate < 0");
		}

		try {
			obj = new SlabInterval(1.0, 3.0, 8.0);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("obj is null");
		}

		assertNotNull(obj);
	}

	@Test
	void testGetEnd() {
		assertEquals(lobj.get(0).getEnd(), 500, 1e-4);
		assertEquals(lobj.get(1).getEnd(), 1500, 1e-4);
		assertEquals(lobj.get(2).getEnd(), 3000, 1e-4);
		assertEquals(lobj.get(3).getEnd(), Double.MAX_VALUE, 1e-4);
	}

	@Test
	void testGetRate() {
		assertEquals(lobj.get(0).getRate(), 2, 1e-4);
		assertEquals(lobj.get(1).getRate(), 3, 1e-4);
		assertEquals(lobj.get(2).getRate(), 5, 1e-4);
		assertEquals(lobj.get(3).getRate(), 8, 1e-4);
	}

	@Test
	void testGetCost() {
		/*
		 * lobj = List.of ( new SlabInterval(0.0, 500.0, 2.0), new SlabInterval(501.0,
		 * 1500.0, 3.0), new SlabInterval(1501.0, 3000.0, 5.0), new SlabInterval(3001.0,
		 * Double.MAX_VALUE, 8.0) );
		 */
		SlabInterval obj = lobj.get(0);
		try {
			assertEquals(obj.getCost(-2.0), 1000.0, 1e-4);
		} catch (IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "litres < 0");
		}

		assertEquals(new SlabInterval(0.0, 400.0, 3.0).getCost(125.0), new SlabInterval(1.0, 400.0, 3.0).getCost(125.0),
				1e-4);

		assertEquals(obj.getCost(500.0), 1000.0, 1e-4);

		obj = lobj.get(1);
		assertEquals(obj.getCost(450.0), 0, 1e-4);

		obj = lobj.get(2);
		assertEquals(obj.getCost(3500.0), 7500.0, 1e-4);

	}

}
