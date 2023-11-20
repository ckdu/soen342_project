package Implementation;

public class Temperature {
	public String unit;
	public int value;
	
	public Temperature(String unit, int value) {
		this.unit = unit;
		this.value = value;
	}
	
	public String toString() {
		return this.unit + " " + this.value;
	}
	
}
