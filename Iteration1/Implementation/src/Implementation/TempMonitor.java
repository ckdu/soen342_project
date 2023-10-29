package Implementation;

public class TempMonitor {
	private SensorRegistry sensorRegistry;
	private LocationRegistry locationRegistry;
	
	public TempMonitor(SensorRegistry sensorRegistry, LocationRegistry locationRegistry) {
		this.sensorRegistry = sensorRegistry;
		this.locationRegistry = locationRegistry;
	}
}