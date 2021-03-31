package net.ezioleq.voidinary.energy;

public interface IEnergy {
	/**
	 * 1 VoidFlux = 1000 units
	 */
	public static final int VOIDFLUX = 1000;

	/**
	 * @return Amount of energy stored in object
	 */
	int getEnergy();

	/**
	 * Set amount of energy stored by object
	 * @param amount
	 */
	void setEnergy(int amount);

	/**
	 * Subtract given amount of energy from object
	 * @param amount
	 */
	void subtractEnergy(int amount);

	/**
	 * Add given amount of energy to object
	 * @param amount
	 */
	void addEnergy(int amount);
}
