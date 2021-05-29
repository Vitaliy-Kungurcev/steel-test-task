package testtask.steel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import testtask.steel.entity.Supply;

import java.time.LocalDate;
import java.util.List;


public interface SupplyRepository extends JpaRepository<Supply, Integer> {
    @Query(value = "SELECT * FROM supply WHERE  supply.date >=:startDate  and supply.date <= :endDate group by provider,price,name", nativeQuery = true)
    List<Supply> getSupplyByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT sum(weight) FROM supply WHERE  supply.date >=:startDate  and supply.date <= :endDate group by provider,price,name", nativeQuery = true)
    List<Integer> getSumWeightProvaiderSupplyByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT sum(price) FROM supply WHERE  supply.date >=:startDate  and supply.date <= :endDate group by provider,price,name", nativeQuery = true)
    List<Integer> getSumPriceProvaiderSupplyByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT count(name) FROM supply WHERE  supply.date >=:startDate  and supply.date <= :endDate group by provider,price,name", nativeQuery = true)
    List<Integer> getcountProvaiderSupplyByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
