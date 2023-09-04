package com.ecommerce.storesystem.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ecommerce.storesystem.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	OrderEntity findOneById(Long id);	
	@Query(value = "SELECT count(*) FROM orders WHERE orders.status_id = :statusId AND orders.account_id = :accountId",nativeQuery = true)
    Long findByStatusIdAndAccountId(@Param("statusId") Long statusId, @Param("accountId") Long accountId);
}
