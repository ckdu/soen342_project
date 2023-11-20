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

	
	public void addSensor(Sensor sensor) {
	}
	
	public void remove(Sensor sensor) {
		sensorLocationPairs.remove(sensor);
		sensorTemperaturePairs.remove(sensor);
		sensorDict.remove(sensor.getSensorId());
	}
	
	public Temperature getTemperatureFromSensor(Sensor sensor) {
		return sensorTemperaturePairs.get(sensor);
	}
	
	public Location getLocationFromSensor(Sensor sensor) {
		return sensorLocationPairs.get(sensor);
	}

	
	public Sensor getSensor(int sensorId){
		if (!sensorDict.containsKey(sensorId)) {
			System.out.println("Invalid sensor ID");
			return null;
		}
		
		Sensor sensor = sensorDict.get(sensorId);
		if (sensor.getIsDeployed()) {
			System.out.println("Sensor is already deployed.");
			return null;
		}
		return sensor;
	}
	
	public void createSensorLocationPair(Sensor sensor, Location location) {
		sensorLocationPairs.put(sensor, location);
	}
	
	public void createSensorTemperaturePair(Sensor sensor, Temperature temperature) {
		sensorTemperaturePairs.put(sensor, temperature);
	}

	


}
