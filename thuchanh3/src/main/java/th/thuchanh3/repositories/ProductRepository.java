package th.thuchanh3.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import th.thuchanh3.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "select * from product where code = :code", nativeQuery = true)
    Product findByCode(@Param("code") String code);
    @Transactional
    @Modifying
    @Query(value = "delete from product where code = :code", nativeQuery = true)
	void deleteByCode(@Param("code") String code);
}
