package edu.icet.test.repository;


import edu.icet.test.model.entity.CustomerEntity;
import edu.icet.test.model.entity.FoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
