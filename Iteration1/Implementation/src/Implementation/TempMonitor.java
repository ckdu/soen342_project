package Implementation;

public class TempMonitor {
	private SensorRegistry sensorRegistry;
	private LocationRegistry locationRegistry;
	
	public TempMonitor(SensorRegistry sensorRegistry, LocationRegistry locationRegistry) {
		this.sensorRegistry = sensorRegistry;
		this.locationRegistry = locationRegistry;
	}
	
	public Temperature readTemperature(int locationId) {
		Location location = locationRegistry.getLocationForReadTemperature(locationId);

		Sensor sensor = locationRegistry.getSensorFromLocation(location);
		
		Temperature temperature = sensorRegistry.getTemperatureFromSensor(sensor);
		System.out.println(temperature.unit + " " + temperature.value);
		return temperature;
	}
}