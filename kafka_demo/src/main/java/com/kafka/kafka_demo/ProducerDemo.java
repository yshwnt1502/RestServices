package com.kafka.kafka_demo;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemo {
	
	public static void main(String[] args)  {

		final Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallback.class);
		String bootstrapServers = "127.0.0.1:9092";
		// TODO Auto-generated method stub
		for (int i = 0; i <= 10; i++) {

			String topic = "first_topic";
			String value = "Hello Word" + Integer.toString(i);
			String key = "_id" + Integer.toString(i);

			Properties prop = new Properties();
			prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
			prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
			prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

			KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

			ProducerRecord<String, String> record = new ProducerRecord(topic, value);
			producer.send(record) ;

				
			producer.flush();
			producer.close();
		}

	}
}

