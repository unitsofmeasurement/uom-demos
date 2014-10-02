package tec.uom.demo.health.se.strava;

import java.util.Properties;





import org.jstrava.connector.JStravaV3;
import org.jstrava.entities.activity.Activity;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.jstrava.entities.athlete.Athlete;

public class StravaDemo {
//	private static final Logger logger = LogManager.getLogger();
	private static String accessToken;
	private static int athleteId;
	private static int activityId;
	private static int updateActivityId;
	private static int clubId;
	private static String gearId;
	private static long segmentId;

	public static void main(String[] args) throws Exception {
		final Properties config = new Properties();
		config.load(StravaDemo.class.getResourceAsStream("/strava.properties"));

        accessToken = config.getProperty("accessToken");
        activityId = Integer.parseInt(config.getProperty("activityId", "0"));
		JStravaV3 strava = new JStravaV3(accessToken);
		
		Athlete athlete = strava.getCurrentAthlete();
		System.out.println("Athlete: " + athlete);
		
		Activity activity = strava.findActivity(activityId);
		System.out.println("City: " + activity.getLocation_city());
	}

}
