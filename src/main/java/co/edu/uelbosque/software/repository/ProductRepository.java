package co.edu.uelbosque.software.repository;

import co.edu.uelbosque.software.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by david on 10/11/16.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {



}
