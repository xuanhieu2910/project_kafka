package xuanhieu.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.kafka.entity.Inventory;
import xuanhieu.kafka.service.InventoryService;

import java.util.*;
@RestController
@RequestMapping(name = "/kafka")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping(value = "/inventory")
    public List<Inventory>findAllInventory(){
        return  inventoryService.findAllInventory();
    }

    @PutMapping(value = "/updateInventory/{id}")
    public String updateInventoryById(@PathVariable("id")Integer id,@RequestBody Inventory inventory){
        if(inventoryService.getInventoryById(id)!=null){
            inventoryService.updateInventory(inventory);
            return "Chỉnh sửa thành công!";
        }
        return "Chỉnh sửa thất bại";
    }
    @GetMapping(value = "/inventory/{id}")
    public Inventory getInventoryById(@PathVariable("id")Integer id){
        if(inventoryService.getInventoryById(id)!=null){
            return inventoryService.getInventoryById(id);
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteInventoryById(@PathVariable("id")Integer id){
        return inventoryService.deleteInventoryById(id);
    }
}
