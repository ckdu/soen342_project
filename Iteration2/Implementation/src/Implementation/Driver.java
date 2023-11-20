package Implementation;

import java.util.HashMap;

public class Driver {

	public static void main(String[] args) {
		//	Create new sensors
		Sensor s1 = new Sensor(1, true);
		Sensor s2 = new Sensor(2, true);
		Sensor s3 = new Sensor(3, true);

		Sensor s4 = new Sensor(4, false);
		Sensor s5 = new Sensor(5, false);
		Sensor s6 = new Sensor(6, false);

		//	Create new locations
		Location l1 = new Location(1);
		Location l2 = new Location(2);
		Location l3 = new Location(3);
		
		Location l4 = new Location(4);
		Location l5 = new Location(5);
		Location l6 = new Location(6);

		//	Create new temperatures
		Temperature t1 = new Temperature("Celcius", 1);
		Temperature t2 = new Temperature("Celcius", 2);
		Temperature t3 = new Temperature("Celcius", 3);

		//	Create location registry
		LocationRegistry locreg = new LocationRegistry();
		locreg.locationDict = new HashMap<Integer, Location>();
		
		locreg.locationDict.put(1, l1);
		locreg.locationDict.put(2, l2);
		locreg.locationDict.put(3, l3);
//		locreg.locationDict.put(4, l4);

		
		locreg.locationSensorPairs = new HashMap<Location, Sensor>();
		locreg.locationSensorPairs.put(l1, s1);
		locreg.locationSensorPairs.put(l2, s2);
		locreg.locationSensorPairs.put(l3, s3);
		
		
		//	Create sensor registry
		SensorRegistry senreg = new SensorRegistry();
		senreg.sensorDict = new HashMap<Integer, Sensor>();
		
		senreg.sensorDict.put(1, s1);
		senreg.sensorDict.put(2, s2);
		senreg.sensorDict.put(3, s3);
		senreg.sensorDict.put(4, s4);

		senreg.sensorLocationPairs = new HashMap<Sensor, Location>();
		
		senreg.sensorLocationPairs.put(s1, l1);
		senreg.sensorLocationPairs.put(s2, l2);
		senreg.sensorLocationPairs.put(s3, l3);
		
		senreg.sensorTemperaturePairs = new HashMap<Sensor, Temperature>();
		
		senreg.sensorTemperaturePairs.put(s1, t1);
		senreg.sensorTemperaturePairs.put(s2, t2);
		senreg.sensorTemperaturePairs.put(s3, t3);
				
		// Create TempMonitor
		TempMonitor tm = new TempMonitor(senreg, locreg);
		
		tm.GetAllLocationsAndTemperatures();
		tm.replaceSensor(4, 1);
		
		
		
		
//		tm.readTemperature(1);
//		tm.deploySensor(4, 4);
		
		
		
		
	}

}
