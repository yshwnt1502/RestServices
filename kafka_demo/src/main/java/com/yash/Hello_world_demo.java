package com.yash;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Hello_world_demo {

	public static void main(String[] args) {
		String bootstrapServers="127.0.0.1:9092";
		// TODO Auto-generated method stub
 
 Properties prop=new Properties();
 prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
 prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
 prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
 
 
 KafkaProducer<String,String> producer=new KafkaProducer<String,String>(prop);
 ProducerRecord<String,String> pr=new ProducerRecord("first_topic","Hello Word");
producer.send(pr);
producer.close();
 
	}

}
