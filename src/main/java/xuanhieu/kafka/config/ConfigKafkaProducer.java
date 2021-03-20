package xuanhieu.kafka.config;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import xuanhieu.kafka.entity.Products;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConfigKafkaProducer {

    public static final String BOOTSTRAP_SERVER_CONFIG="127.0.0.1:9092";

    @Bean
    public ProducerFactory<String, String>producerFactory(){
        Map<String,Object>objectMap = new HashMap<>();
        objectMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVER_CONFIG);
        objectMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        objectMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(objectMap);
    }

    @Bean
    public KafkaTemplate<String,String>kafkaTemplate(){return new KafkaTemplate<>(producerFactory());}
}
