package co.edu.uelbosque.software.repository;

import co.edu.uelbosque.software.entities.Product;
import co.edu.uelbosque.software.entities.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by david on 10/11/16.
 */
public interface ShoppingRepository extends JpaRepository<Shopping, Integer> {



}
