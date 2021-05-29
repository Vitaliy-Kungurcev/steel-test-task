package testtask.steel.service;//package com.example.lunch.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testtask.steel.entity.Supply;
import testtask.steel.repository.SupplyRepository;

import java.time.LocalDate;
import java.util.List;


@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;


    @Override
    public void save(Supply supply, LocalDate start, LocalDate end) {
        supply.setDate(start);
        supplyRepository.save(supply);

        while (start.isBefore(end)) {
            start = start.plusDays(1);
            Supply supplyNew = new Supply(supply.getType(), supply.getName(), supply.getProvider(), supply.getWeight(), supply.getPrice());
            supplyNew.setDate(start);
            supplyRepository.save(supplyNew);
        }
    }

    @Override
    public List<Supply> getsupplyForThePeriod(LocalDate startDate, LocalDate endDate) {
        List<Supply> supplyByPeriod = supplyRepository.getSupplyByPeriod(startDate, endDate);
        List<Integer> cont = supplyRepository.getcountProvaiderSupplyByPeriod(startDate, endDate);
        List<Integer> sumW = supplyRepository.getSumWeightProvaiderSupplyByPeriod(startDate, endDate);
        List<Integer> sumP = supplyRepository.getSumPriceProvaiderSupplyByPeriod(startDate, endDate);
        for (int i = 0; i < supplyByPeriod.size(); i++) {
            supplyByPeriod.get(i).setSum_price(sumP.get(i) * supplyByPeriod.get(i).getPrice());
            supplyByPeriod.get(i).setSum_weight(sumW.get(i));
            supplyByPeriod.get(i).setCount(cont.get(i));
        }
        return supplyByPeriod;
    }

    @Override
    public List<Integer> coutingRezult(List<Supply> rezult) {
        int allPrice = 0;
        int allWeight = 0;

        for (Supply supply : rezult) {
            allPrice = allPrice + supply.getSum_price();
            allWeight = allWeight + supply.getSum_weight();
        }

        return List.of(allWeight, allPrice);
    }


}





