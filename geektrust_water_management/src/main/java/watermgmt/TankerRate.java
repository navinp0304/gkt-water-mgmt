package main.java.watermgmt;

import java.util.Arrays;
import java.util.List;

public class TankerRate implements IRateCalculator {
	/**
	 * List of slab intervals and their costs
	 */

	// @formatter:off

	private List<SlabInterval> listSlabs = Arrays.asList
	(
		new SlabInterval(0.0, 500.0, 2.0),
		new SlabInterval(501.0, 1500.0, 3.0),
		new SlabInterval(1501.0, 3000.0, 5.0),
		new SlabInterval(3001.0, Double.MAX_VALUE, 8.0)
	);

	// @formatter:on

	@Override
	public Double getRate(Double litres) {
		if (litres < 0.0)
			throw new IllegalArgumentException("litres < 0");

		double tot = 0.0;

		// for each slab you get the value
		for (SlabInterval eachSlab : listSlabs) {
			tot += eachSlab.getCost(litres);

			/**
			 * the next interval is not relevant, it would only be relevant in case litres
			 * is beyond end of this interval i.e litres > End. If litres <= End , i don't
			 * need to compute all the next slabs.
			 */
			if (litres <= eachSlab.getEnd()) {
				break;
			}

		}

		return tot;
	}

	/**
	 * get litres for slab rate.
	 */
	@Override
	public Double getLitres(ApartmentBase aptObj) {
		if (aptObj == null)
			throw new IllegalArgumentException("aptObj argument is null");
		return 1.0 * aptObj.getTotalLitres() - aptObj.getDefaultLitres();
	}

}
