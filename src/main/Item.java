package main;
import java.util.Comparator;

public class Item implements Comparable<Item> {

	private int Fuel_Tank;
	private int Horsepower;
	private int Curb_Weight;

	public static Comparator<Item> BY_Horsepower = new ByHorsepower();
	public static Comparator<Item> BY_Curb_Weight = new ByCurbWeight();

	public Item(int Fuel_Tank, int Horsepower, int Curb_Weight) {
		this.Fuel_Tank = Fuel_Tank;
		this.Horsepower = Horsepower;
		this.Curb_Weight = Curb_Weight;
	}

	public String toString() {
		return "{Fuel_Tank: " + this.Fuel_Tank + "; Horsepower: "
				+ this.Horsepower + "; Curb_Weight: " + this.Curb_Weight + "}";
	}

	@Override
	public int compareTo(Item that) {
		return this.Fuel_Tank - that.Fuel_Tank;
	}

	public static class ByHorsepower implements Comparator<Item> {

		@Override
		public int compare(Item first, Item second) {
			return first.Horsepower - second.Horsepower;
		}

	}

	public static class ByCurbWeight implements Comparator<Item> {

		@Override
		public int compare(Item first, Item second) {
			return first.Curb_Weight - second.Curb_Weight;
		}

	}
}
