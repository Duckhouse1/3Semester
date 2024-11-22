package MQTT;
import java.io.IOException;

import MQTT.SimpleMQTTCallBack;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTprogram {
    public static MqttClient sampleClient;
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        String broker = "tcp://192.168.0.115:1883";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            sampleClient = new MqttClient(broker, MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.setCallback(new SimpleMQTTCallBack());
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            sampleClient.subscribe("tele/grp3870/SENSOR");
            sampleClient.subscribe("tele/grp3870/STATE");

            Thread.sleep(200000);
            // put real stuff here        < -------- !!!!

//            publishMessage(sampleClient,"cmnd/grp3870/Power1","1"); //Denne linje tænder og starter fugtighedmaskine
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();

        }
    }

    //opg6pgm
    public static void publishMessage(String topicsend, String content) throws MqttPersistenceException, MqttException {
        // Laver en publish p  sampleClient med topic topicsend og indhold content.
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());
        //System.out.println(content.getBytes());
        sampleClient.publish(topicsend, message);
        System.out.println("Message published");
    }
}