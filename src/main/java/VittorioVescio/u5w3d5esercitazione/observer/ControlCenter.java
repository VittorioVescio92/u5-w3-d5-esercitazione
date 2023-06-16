package VittorioVescio.u5w3d5esercitazione.observer;

public class ControlCenter implements Observer {

	@Override
	public void update(FireSensor fs) {
		if (fs.getSmokeLevel() > 5) {

			String url = "http://host/alarm?fireSensorId=" + fs.getFireSensorId() + "&lat=" + fs.getLatitudine()
					+ "&lon=" + fs.getLongitudine() + "&smokelevel=" + fs.getSmokeLevel();
			System.out.println();
			System.out.println("Allarme, incendio in corso: " + url);
			System.out.println();
		} else {
			System.out.println();
			System.out.println("Tutto ok, livelli di fumo nella norma!");
			System.out.println();
		}
	}

}