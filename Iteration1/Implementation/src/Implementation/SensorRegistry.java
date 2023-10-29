package Implementation;

import java.util.HashMap;
import java.util.List;

public class SensorRegistry {
	
	private List<Sensor> sensors;
	
	
	//	ID ---> Sensor HashMap
	HashMap<Integer, Sensor> sensorDict = new HashMap<Integer, Sensor>();
	
	
	//	Location ---> Sensor HashMaps
	HashMap<Sensor, Location> sensorLocationPairs = new HashMap<Sensor, Location>();
	
	HashMap<Sensor, Temperature> sensorTemperaturePairs = new HashMap<Sensor, Temperature>();

	
	
	
	public Temperature getTemperatureFromSensor(Sensor sensor) {
		return sensorTemperaturePairs.get(sensor);
	}
		
	public void create(Sensor sensor, Location location) {
		sensorLocationPairs.put(sensor, location);
	}



}
