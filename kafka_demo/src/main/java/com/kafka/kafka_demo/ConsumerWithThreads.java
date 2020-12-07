package com.kafka.kafka_demo;

	import java.time.Duration;
	import java.util.Arrays;
	import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
	import org.apache.kafka.clients.consumer.ConsumerRecord;
	import org.apache.kafka.clients.consumer.ConsumerRecords;
	import org.apache.kafka.clients.consumer.KafkaConsumer;
	import org.apache.kafka.common.serialization.StringDeserializer;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	 class ConsumerWithThreads1 {

		
	public static void main(String[] args) {
			
			String bootstrapserver="127.0.0.1:9092";
			String topic ="first_topic";
			String value="Hello Yashwant";
			String groupId="my-sixth-application";
		
		
		final Logger logger=LoggerFactory.getLogger(ConsumerWithCallBacks.class.getName());
		
		Properties property=new Properties();
		property.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
		property.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		property.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		property.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		property.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		KafkaConsumer<String,String> consumer=new KafkaConsumer<String,String>(property);
		consumer.subscribe(Arrays.asList(topic));
		
		while(true) {
			ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));
			
			for(ConsumerRecord<String,String> record:records) {
				logger.info("key "+record.key()+" value "+record.value());
				logger.info("Partition "+record.partition()+" Offset "+record.offset());
			}
		}
	}

	}
public class ConsumerWithThreads implements Runnable{
	
	private CountDownLatch latch;

	public ConsumerWithThreads(CountDownLatch latch) {
		this.latch=latch;
	}

	public void run() {
		// TODO Auto-generated method stub
		
		
		public void shutDown() {
			
		}
	}
	
}
