//opg7pgm
package MQTT;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

public class SimpleMQTTCallBack implements MqttCallback {
    int status = 0;
    double temperatur;
    double humidity;
    String power;

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String res = new String(mqttMessage.getPayload());
        // res indeholder en m ling som et JSON-object
        // put real stuff here     < --------    !!!!!!!!!!
        System.out.println(res);

        if (!res.contains("POWER")) {
            JSONObject json = new JSONObject(res);
            JSONObject json2 = json.getJSONObject("AM2301");
            temperatur = json2.getDouble("Temperature");
            humidity = json2.getDouble("Humidity");
            if (humidity > 50 && power.equals("OFF")) {
                MQTT.MQTTprogram.publishMessage("cmnd/grp3870/Power1", "1");
            } else {
                if (humidity < 50 && power.equals("ON"))
                    MQTT.MQTTprogram.publishMessage("cmnd/grp3870/Power1", "0");

            }

        } else {
            JSONObject json = new JSONObject(res);
            power = json.getString("POWER");
            if (power.equals("ON")) {
                System.out.println("Temperatur: " + temperatur + " Humidity: " + humidity);
            } else {

            }
        }

    }


    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }
}