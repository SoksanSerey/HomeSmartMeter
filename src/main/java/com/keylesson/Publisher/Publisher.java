package com.keylesson.Publisher;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Publisher {

	public static void main(String arg[]){
		String topic = "Home";
        String content = "Home";
        int qos = 2;
        String broker = "tcp://167.99.71.72:1883";
        @SuppressWarnings("unused")
		String clientId = "Home";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            
            MqttClient sampleClient = new MqttClient(broker, MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            System.out.println();
                        
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
            
        }
	}
	public void sub( String mac){
		String topic = "Home";
        String content = "HomeSub";
        int qos = 2;
        String broker = "tcp://167.99.71.72:1883";
        @SuppressWarnings("unused")
		String clientId = "Home";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            
            MqttClient sampleClient = new MqttClient(broker, MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(mac.getBytes());  
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            //sampleClient.disconnect();
           // System.out.println("Disconnected");
            System.out.println();
                        
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
            
        }
	}
}
