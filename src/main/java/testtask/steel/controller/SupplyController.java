package testtask.steel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import testtask.steel.entity.Supply;
import testtask.steel.service.SupplyService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@Controller
public class SupplyController {

    @Autowired
    private SupplyService supplyService;


    @GetMapping("/")
    public String startPage() {

        return "startPage";
    }

    @GetMapping("/newsupply")
    public String addSupply(Model model) {
        model.addAttribute("supply", new Supply());
        return "supplyForm";
    }

    @PostMapping("/save")
    public String saveSupply(@Valid @ModelAttribute("supply") Supply supply, BindingResult bindingResult,
                             @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endOfDate) {

        if (bindingResult.hasErrors() || startDate.isAfter(endOfDate)) {
            return "supplyForm";
        }
        supplyService.save(supply, startDate, endOfDate);
        return "redirect:/";
    }

    @PostMapping("/history")
    public String historySupply(Model model,
                                @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endOfDate) {

        List<Supply> supplyForThePeriod = supplyService.getsupplyForThePeriod(startDate, endOfDate);
        List<Integer> rezult = supplyService.coutingRezult(supplyForThePeriod);
        model.addAttribute("rezult", rezult);
        model.addAttribute("start", startDate);
        model.addAttribute("end", endOfDate);
        model.addAttribute("history", supplyForThePeriod);
        return "historySupply";
    }
}
