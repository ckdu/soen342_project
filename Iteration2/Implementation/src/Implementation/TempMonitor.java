package Implementation;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

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
        // Get the sensor from the registry
		Sensor sensor = sensorRegistry.getSensor(sensorId);
		
        // Get the location from the registry
		Location location = locationRegistry.getLocationForDeploySensor(locationId);

        //	Deploy the sensor
		if (sensor == null || location == null) {
		} 
		else {
            // Add the sensor and the location to their respective hashMaps
			sensorRegistry.createSensorLocationPair(sensor, location);
			locationRegistry.create(sensor, location);
			
			sensor.setIsDeployed(true);
			System.out.println("Sensor has been deployed.");
		}
	}
    
    public void replaceSensor(int sensorId, int locationId) {
    	
        // Get the sensor from the registry
		Sensor newSensor = sensorRegistry.getSensor(sensorId);
		
        // Get the location from the registry
		Location location = locationRegistry.getLocationForReadTemperature(locationId);

        //	check that the new sensor and location are valid
		if (newSensor == null)  {
			System.out.println("Error: New sensor doesn't exist");
			return;
		} 
		
		if (location == null)  {
			System.out.println("Error: Location doesn't exist");
			return;
		} 

		// Check that the sensor is not already deployed
		if (newSensor.getIsDeployed()) {
			System.out.println("Error: Sensor to deploy is already delpoyed.");
			return;
		}
		
		// Grab old sensor from location
		Sensor oldSensor = locationRegistry.getSensorFromLocation(location);
		// Save the old sensor's temperature
		Temperature temp = sensorRegistry.getTemperatureFromSensor(oldSensor);
	
		// Replace the old sensor by the new sensor in locationRegistry
		if (locationRegistry.ReplaceSensorInLocation(location, newSensor) == null) {
			System.out.println("Error: No sensor in location");
			return;
		}
		
		// Remove old sensor from HashMaps
		sensorRegistry.remove(oldSensor);
				
		// Add new sensor to SensorDict
		sensorRegistry.sensorDict.put(Collections.max(sensorRegistry.sensorDict.keySet()) + 1,  newSensor);
		
		// Add new sensor to SensorRegistry
		sensorRegistry.createSensorLocationPair(newSensor, location);
		sensorRegistry.createSensorTemperaturePair(newSensor, temp);
		
		newSensor.setIsDeployed(true);
		System.out.println("Sensor " + newSensor.toString() + " has been deployed to location " + location.toString() + ".");
	}

    public void GetAllLocationsAndTemperatures() {
    	Collection<Sensor> sensors = sensorRegistry.sensorDict.values();
    	for (Sensor s: sensors) {
    		if (!s.getIsDeployed()) {continue;}
    		
    		Location l = sensorRegistry.getLocationFromSensor(s);
    		Temperature t = sensorRegistry.getTemperatureFromSensor(s);
    		System.out.println("Location " + l.locationId + " has temperature: " + t.toString());
    	}
    	
    }
    
    
    
    

    
    
}