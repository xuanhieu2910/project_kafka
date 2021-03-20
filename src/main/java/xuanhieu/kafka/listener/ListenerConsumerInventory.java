package xuanhieu.kafka.listener;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import xuanhieu.kafka.dto.InventoryDto;
import xuanhieu.kafka.entity.Inventory;

@Service
public class ListenerConsumerInventory {

    private static final Gson gson = new Gson();
    private static Inventory inventory;

    @Autowired
    InventoryDto inventoryDto;

    @KafkaListener(topics = "update-inventory", groupId = "group-id")
    public void listenerUpdateInventory(String message) {
        inventory = gson.fromJson(message, Inventory.class);
    }
}
