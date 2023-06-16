package VittorioVescio.u5w3d5esercitazione.observer;

public class ControlCenter implements Observer {

	@Override
	public void update(FireSensor fs) {
		String url = "http://host/alarm?fireSensorId=" + fs.getFireSensorId() + "&lat=" + fs.getLatitudine() + "&lon="
				+ fs.getLongitudine() + "&smokelevel=" + fs.getSmokeLevel();

		if (fs.getSmokeLevel() > 5) {
			if (url.contains("lat=41.871857&lon=12.477398")) {
				System.out.println();
				System.out.println(
						"Attenzione, gli uffici di Epicode sono in fiamme! Fare Commit + Push prima di abbandonare l'edificio!");
			} else {
				System.out.println();
				System.out.println("Allarme! Incendio in corso: " + url);
			}
		} else {
			System.out.println();
			System.out.println("Tutto ok, livelli di fumo nella norma!");
		}
	}
}