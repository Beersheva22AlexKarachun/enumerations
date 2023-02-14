package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit unit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.unit = lengthUnit;
	}

	@Override
	/**
	 * equals two Length objects according to LengthUnit and amount 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Length lenght = (Length) obj;

		return compareTo(lenght) == 0;
	}

	@Override
	/**
	 * 
	 * @param o
	 * @return < 0 "this" object less than "o" object, > 0 "this" object greater
	 *         than "o" object, == 0 "this" object equals "o" object,
	 */
	public int compareTo(Length o) {
		return Float.compare(amount * unit.getValue(), o.amount * o.unit.getValue());
	}

	/**
	 * 
	 * @param newUnit
	 * @return new Length object with a given LengthUnit example,
	 *         convert(LengthUnit.M) returns Length in meters
	 */
	public Length convert(LengthUnit newUnit) {
		return new Length(amount * unit.getValue() / newUnit.getValue(), newUnit);
	}

	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20.0M (string expression of Length object presenting 20 meters)
	 */
	public String toString() {
		return "" + amount + unit;
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}
}