package VittorioVescio.u5w3d5esercitazione;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import VittorioVescio.u5w3d5esercitazione.antincendio_factory.DefaultFireSensorFactory;
import VittorioVescio.u5w3d5esercitazione.antincendio_factory.FireSensorFactory;
import VittorioVescio.u5w3d5esercitazione.antincendio_observer.ControlCenter;
import VittorioVescio.u5w3d5esercitazione.antincendio_observer.FireSensor;

public class ControlCenterTest {
	private FireSensor fireSensor;
	private ControlCenter controlCenter;
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void setup() {
		FireSensorFactory fireSensorFactory = new DefaultFireSensorFactory();
		fireSensor = fireSensorFactory.createFireSensor(40.254478, 122.255577);
		fireSensor.setFireSensorId(1234);
		controlCenter = new ControlCenter();
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	public void smokeLevelGreaterThan5() {
		fireSensor.setSmokeLevel(6);
		controlCenter.update(fireSensor);
		String expectedOutput = "Allarme! Incendio in corso: http://host/alarm?fireSensorId=1234&lat=40.254478&lon=122.255577&smokelevel=6";
		assertEquals(expectedOutput, outputStream.toString().trim());
	}

	@Test
	public void smokeLevelLessThanOrEqual5() {
		fireSensor.setSmokeLevel(3);
		controlCenter.update(fireSensor);
		String expectedOutput = "Tutto ok, livelli di fumo nella norma!";
		assertEquals(expectedOutput, outputStream.toString().trim());
	}

	@Test
	public void isEpicodeOnFire() {
		fireSensor.setSmokeLevel(10);
		fireSensor.setLatitudine(41.871857);
		fireSensor.setLongitudine(12.477398);
		controlCenter.update(fireSensor);
		String expectedOutput = "Allarme incendio! Gli uffici di Epicode sono in fiamme! Fare Commit + Push prima di abbandonare l'edificio!";
		assertEquals(expectedOutput, outputStream.toString().trim());
	}
}
