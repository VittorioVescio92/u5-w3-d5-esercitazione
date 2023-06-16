package VittorioVescio.u5w3d5esercitazione.antincendio_observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ObserverRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		FireSensor fireSensor1 = new FireSensor(-7.418047, 110.130657); // easter egg :D
		FireSensor fireSensor2 = new FireSensor(41.871857, 12.477398); // easter egg :D
		FireSensor fireSensor3 = new FireSensor(15.584632, 100.785413);
		ControlCenter controlCenter = new ControlCenter();

		fireSensor1.addObserver(controlCenter);
		fireSensor2.addObserver(controlCenter);
		fireSensor3.addObserver(controlCenter);

		fireSensor1.setSmokeLevel(5);
		fireSensor1.setSmokeLevel(7);
		fireSensor2.setSmokeLevel(10);
		fireSensor3.setSmokeLevel(11);
	}

}
