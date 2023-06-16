package VittorioVescio.u5w3d5esercitazione.observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ObserverRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		FireSensor fireSensor1 = new FireSensor(109.94, 7.30);
		ControlCenter controlCenter = new ControlCenter();

		fireSensor1.addObserver(controlCenter);

		fireSensor1.setSmokeLevel(3);
		fireSensor1.setSmokeLevel(7);
	}

}
