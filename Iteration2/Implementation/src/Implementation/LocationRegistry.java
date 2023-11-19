package Implementation;

import java.util.HashMap;
import java.util.List;

public class LocationRegistry {
	private List<Location> locations;
	
	//	ID ---> Location HashMap
	HashMap<Integer, Location> locationDict = new HashMap<Integer, Location>();
	
	// Location ---> Sensor HashMap
	HashMap<Location, Sensor> locationSensorPairs = new HashMap<Location, Sensor>();

	
	public void addLocation(Location location) {
	}
	
	
	public Sensor ReplaceSensorInLocation(Location location, Sensor newSensor) {
		return locationSensorPairs.replace(location, newSensor);
	}
	
	public Location getLocationForDeploySensor(int locationId){
		if (!locationDict.containsKey(locationId)) {
			System.out.println("Location not covered.");
			return null;
		}
		
		Location location = locationDict.get(locationId);
		
		if (locationSensorPairs.containsKey(location)){
			System.out.println("Location already covered. ");
			return null;
		}
		
		else {
			return location;
		}		
	}
	
	public Location getLocationForReadTemperature(int locationId){
		if (!locationDict.containsKey(locationId)) {
			System.out.println("Location not covered. ");
			return null;
		}
		
		Location location = locationDict.get(locationId);
		
		if (!locationSensorPairs.containsKey(location)){
			System.out.println("Location has no sensor. ");
			return null; 
		}
		else {
			return location;
		}		
	}
	
	public Sensor getSensorFromLocation(Location location) {
		return locationSensorPairs.get(location);
	}
	
	
	public void create(Sensor sensor, Location location) {
		locationSensorPairs.put(location, sensor);
	}
	
	
	
	
	
}
