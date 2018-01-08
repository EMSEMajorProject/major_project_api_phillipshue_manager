package fr.majeur.info.iot_lamp_database;

public class Util {
    public static Long id_lamp = Long.valueOf(10);
    public static String[] topics = {"switchTopic", "lumTopic", "briTopic", "satTopic"};
    public static String BrokerUrl = "tcp://m23.cloudmqtt.com:15317";
    public static String MqttUser = "backoffice";
    public static String MqttPassword = "backoffice";
    public static String MqqtClintId = "BackOffice";
}
