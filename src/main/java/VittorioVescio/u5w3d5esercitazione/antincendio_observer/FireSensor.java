package VittorioVescio.u5w3d5esercitazione.antincendio_observer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FireSensor {
	private List<Observer> observers = new ArrayList<>();
	private int fireSensorId;
	private int smokeLevel;
	private double latitudine;
	private double longitudine;

	public FireSensor(int fireSensorId, double latitudine, double longitudine) {
		super();
		this.fireSensorId = fireSensorId;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public void addObserver(Observer observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		notifyObservers();
	}

	private void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

}
