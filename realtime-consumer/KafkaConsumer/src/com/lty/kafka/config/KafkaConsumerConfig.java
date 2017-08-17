package com.lty.kafka.config;

import java.util.HashMap;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerConfig extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 7775720340074223958L;
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
	private static ResourceBundle bundle;
	
	static {
		bundle = ResourceBundle.getBundle("config");
		if (bundle == null) {
			logger.error("类路径下找不到config.properties配置文件！");
			Runtime.getRuntime().exit(1);
		}
	}

	public KafkaConsumerConfig() {
		this.put("bootstrap.servers", bundle.getString("kafka.bootstrap.servers"));
		this.put("group.id", String.valueOf(System.currentTimeMillis()));
		this.put("enable.auto.commit", bundle.getString("enable.auto.commit"));
		this.put("auto.commit.interval.ms", bundle.getString("auto.commit.interval.ms"));
		this.put("session.timeout.ms", bundle.getString("session.timeout.ms"));
		this.put("auto.offset.reset", bundle.getString("auto.offset.reset"));
		this.put("key.deserializer", bundle.getString("key.deserializer"));
		this.put("value.deserializer", bundle.getString("value.deserializer"));
	}
}