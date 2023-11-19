package Implementation;

public class Sensor {
	private int sensorId;
	private Boolean isDeployed;
	
	
	public Sensor(int id, boolean isDeployed) {
		this.sensorId = id;
		this.isDeployed = isDeployed;
	}
	
	public void deploy() {};
	
	public int getSensorId() {return this.sensorId;}
		
	public Boolean getIsDeployed() {
		return this.isDeployed;
	}
	
	public void setIsDeployed(boolean bool) {
		this.isDeployed = bool;
	}
}
