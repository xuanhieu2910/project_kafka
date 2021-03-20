package xuanhieu.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xuanhieu.kafka.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("SELECT iv FROM Inventory iv WHERE iv.products.idProduct=:id")
    Inventory getInventoriesByIdProduct(@Param("id") Integer id);

}
