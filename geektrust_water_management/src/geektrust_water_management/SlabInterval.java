package geektrust_water_management;

public class SlabInterval {
	private Double Start;
	private Double End;
	private Double Rate;

	SlabInterval(Double start, Double end, Double rate) {
		if (start < 0)
			throw new IllegalArgumentException("start < 0");
		if (end < 0)
			throw new IllegalArgumentException("end < 0");
		if (end < start)
			throw new IllegalArgumentException("end < start");
		if (rate < 0)
			throw new IllegalArgumentException("rate < 0");

		Start = start;
		End = end;
		Rate = rate;
	}

	public Double getEnd() {
		return End;
	}

	public Double getRate() {
		return Rate;
	}

	/**
	 * get cost for litres (absolute total) in interval [start,End]
	 *
	 * @param litres
	 * @return
	 */
	public Double getCost(Double litres) {
		if (litres < 0)
			throw new IllegalArgumentException("litres < 0");

		// this interval doesn't contribute anything
		// ex. litres is 5 and slab interval is [7,10]
		// cost is 0
		if (litres < Start)
			return 0.0;

		Double newStart = Start;
		/**
		 * This is done so that Start at 0 litres or start at 1 litres doesn't make a
		 * difference. 0 litres is never counted and we can do End - newStart + 1
		 * uniformly
		 */
		if (newStart == 0) {
			newStart = 1.0;
		}

		// this whole [7,10] interval contributes
		// ex litres is 12 and slab interval is [7,10]
		// cost is (10-7)*Rate
		if (litres > End)
			return (End - newStart + 1) * Rate;

		// litres lie between [Start,End ] where X <= End
		// cost is (litres-Start) * Rate
		return (litres - newStart + 1) * Rate;

	}

}
