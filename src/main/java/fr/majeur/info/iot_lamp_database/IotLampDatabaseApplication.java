package fr.majeur.info.iot_lamp_database;

import fr.majeur.info.iot_lamp_database.MQTT.CloudMQTT;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotLampDatabaseApplication {

	public static void main(String[] args) throws MqttException {
		SpringApplication.run(IotLampDatabaseApplication.class, args);
		CloudMQTT.init();
		CloudMQTT.subscribe(Util.topics);
	}
}
