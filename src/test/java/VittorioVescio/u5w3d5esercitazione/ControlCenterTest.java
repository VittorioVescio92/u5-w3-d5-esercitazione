package VittorioVescio.u5w3d5esercitazione;

import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import VittorioVescio.u5w3d5esercitazione.antincendio_observer.ControlCenter;
import VittorioVescio.u5w3d5esercitazione.antincendio_observer.FireSensor;

public class ControlCenterTest {
	private FireSensor fireSensor;
	private ControlCenter controlCenter;
	private PrintStream mockPrintStream;

	@BeforeEach
	public void setup() {
		fireSensor = new FireSensor(40.254478, 122.255577);
		fireSensor.setFireSensorId(1234);
		controlCenter = new ControlCenter();
		mockPrintStream = Mockito.mock(PrintStream.class);
		System.setOut(mockPrintStream);
	}

	@Test
	public void smokeLevelGreaterThan5() {
		fireSensor.setSmokeLevel(6);
		controlCenter.update(fireSensor);
		Mockito.verify(mockPrintStream).println(
				"Allarme! Incendio in corso: http://host/alarm?fireSensorId=1234&lat=40.254478&lon=122.255577&smokelevel=6");
	}

	@Test
	public void smokeLevelLessThanOrEqual5() {
		fireSensor.setSmokeLevel(3);
		controlCenter.update(fireSensor);
		Mockito.verify(mockPrintStream).println("Tutto ok, livelli di fumo nella norma!");
	}

	@Test
	public void isEpicodeOnFire() {
		fireSensor.setSmokeLevel(10);
		fireSensor.setLatitudine(41.871857);
		fireSensor.setLongitudine(12.477398);
		controlCenter.update(fireSensor);
		Mockito.verify(mockPrintStream).println(
				"Allarme incendio! Gli uffici di Epicode sono in fiamme! Fare Commit + Push prima di abbandonare l'edificio!");
	}
}
