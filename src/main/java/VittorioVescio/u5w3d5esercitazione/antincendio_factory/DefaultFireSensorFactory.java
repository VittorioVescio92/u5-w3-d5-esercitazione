package VittorioVescio.u5w3d5esercitazione.antincendio_factory;

import java.util.Random;

import org.springframework.stereotype.Component;

import VittorioVescio.u5w3d5esercitazione.antincendio_observer.FireSensor;

@Component
public class DefaultFireSensorFactory implements FireSensorFactory {
	private Random r = new Random();

	@Override
	public FireSensor createFireSensor(double latitudine, double longitudine) {
		FireSensor fireSensor = new FireSensor();
		fireSensor.setLatitudine(latitudine);
		fireSensor.setLongitudine(longitudine);
		fireSensor.setFireSensorId(r.nextInt(0, 20));
		return fireSensor;
	}

}
