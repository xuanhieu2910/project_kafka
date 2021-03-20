package xuanhieu.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.kafka.entity.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
}
