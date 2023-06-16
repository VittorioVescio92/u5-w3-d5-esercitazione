package VittorioVescio.u5w3d5esercitazione.antincendio_factory;

import VittorioVescio.u5w3d5esercitazione.antincendio_observer.FireSensor;

public interface FireSensorFactory {
	FireSensor createFireSensor(double latitudine, double longitudine);
}
