package com.ra.controller;

import com.ra.model.Bill;
import com.ra.model.BillDetails;
import com.ra.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/billDetailsController")
public class BillDetailController {
    @Autowired
    BillDetailService billDetailService;
    private static final int SIZE = 3;
    private static int pageDefault = 1;
    private static String directionDefault = "ASC";
    private static String sortByDefault = "billDetailId";

    @GetMapping(value = "/getAll")
    public ModelAndView displayBill(@RequestParam int billId, Optional<Integer> page, Optional<String> direction, Optional<String> sortBy) {
        ModelAndView modelAndView = new ModelAndView("billDetails");
        pageDefault = page.orElse(pageDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        List<BillDetails> billDetails = billDetailService.displayBillDetail(billId, pageDefault - 1, SIZE, directionDefault, sortByDefault);
        List<Integer> listPage = billDetailService.getListPage(billId, SIZE);
        modelAndView.addObject("page", pageDefault);
        modelAndView.addObject("direction", directionDefault);
        modelAndView.addObject("sortBy", sortByDefault);
        modelAndView.addObject("billDetailList", billDetails);
        modelAndView.addObject("listPage", listPage);
        return modelAndView;
    }
}
