package Implementation;

public class TempMonitor {
	private SensorRegistry sensorRegistry;
	private LocationRegistry locationRegistry;
	
	public TempMonitor(SensorRegistry sensorRegistry, LocationRegistry locationRegistry) {
		this.sensorRegistry = sensorRegistry;
		this.locationRegistry = locationRegistry;
	}
	
	public Temperature readTemperature(int locationId) {
        // Get the location from the registry
		Location location = locationRegistry.getLocationForReadTemperature(locationId);

        // Get the sensor from the location
		Sensor sensor = locationRegistry.getSensorFromLocation(location);
		
		Temperature temperature = sensorRegistry.getTemperatureFromSensor(sensor);
		System.out.println(temperature.unit + " " + temperature.value);
		return temperature;
	}

    public void deploySensor(int sensorId, int locationId) {
		Sensor sensor = sensorRegistry.getSensor(sensorId);
		
		Location location = locationRegistry.getLocationForDeploySensor(locationId);

		if (sensor == null || location == null) {
		} 
		else {
			sensorRegistry.create(sensor, location);
			locationRegistry.create(sensor, location);
			
			sensor.setIsDeployed(true);
			System.out.println("Sensor has been deployed.");
		}
	}
}