package testtask.steel.service;


import testtask.steel.entity.Supply;

import java.time.LocalDate;
import java.util.List;

public interface SupplyService {


    void save(Supply supply, LocalDate start, LocalDate end);

    List<Integer> coutingRezult(List<Supply> rezult);

    List<Supply> getsupplyForThePeriod(LocalDate startDate, LocalDate endOfDate);


}
