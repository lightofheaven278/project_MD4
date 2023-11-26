package com.ra.controller;

import com.google.protobuf.StringValue;
import com.ra.model.Account;
import com.ra.model.Bill;
import com.ra.model.BillDetails;
import com.ra.model.Product;
import com.ra.service.AccountService;
import com.ra.service.BillDetailService;
import com.ra.service.BillService;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/billController")
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    BillDetailService billDetailService;
    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;
    private static final int SIZE = 3;
    private static int pageDefault = 1;
    private static String directionDefault = "ASC";
    private static String sortByDefault = "billId";

    @GetMapping(value = "/getAll")
    public ModelAndView displayBill(Optional<Integer> page, Optional<String> direction, Optional<String> sortBy) {
        ModelAndView modelAndView = new ModelAndView("bills");
        pageDefault = page.orElse(pageDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        List<Bill> billList = billService.displayBill(pageDefault - 1, SIZE, directionDefault, sortByDefault);
        List<Integer> listPage = billService.getListPage(SIZE);
        modelAndView.addObject("page", pageDefault);
        modelAndView.addObject("direction", directionDefault);
        modelAndView.addObject("sortBy", sortByDefault);
        modelAndView.addObject("billList", billList);
        modelAndView.addObject("listPage", listPage);
        return modelAndView;
    }

    @GetMapping(value = "/initAddBill")
    public String initAddBill(ModelMap modelMap) {
        List<Account> accountList = accountService.getAllAccount();
        List<Product> productList = productService.getAllProducts();
        Bill newBill = new Bill();
        BillDetails newBillDetail = new BillDetails();
        newBillDetail.setBill(newBill);
        newBill.getBillDetailsList().add(newBillDetail);
        modelMap.addAttribute("accountList", accountList);
        modelMap.addAttribute("productList", productList);
        modelMap.addAttribute("newBill", newBill);
        modelMap.addAttribute("newBillDetail", newBillDetail);
        return "billInit";
    }

    @PostMapping(value = "/addNewBill")
    public String addNewBill(Bill newBill, BillDetails newBillDetail) {
        boolean addBillResult = billService.save(newBill);
        boolean addBillDetailResult = billDetailService.save(newBillDetail);
        if (addBillResult) {
            if (addBillDetailResult) {
                return "redirect:getAll";
            } else {
                return "error";
            }
        } else {
            return "error";
        }

    }

    @GetMapping(value = "/searchBill")
    public ModelAndView searchBill(@RequestParam(name = "billSearch") String billId) {
        if (!billId.equals("")) {
            ModelAndView modelAndView = new ModelAndView("billSearch");
            Bill billSearch = billService.getBillById(Integer.parseInt(billId));
            modelAndView.addObject("billSearch", billSearch);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("bills");
            List<Bill> billList = billService.displayBill(pageDefault - 1, SIZE, directionDefault, sortByDefault);
            List<Integer> listPage = billService.getListPage(SIZE);
            modelAndView.addObject("page", pageDefault);
            modelAndView.addObject("direction", directionDefault);
            modelAndView.addObject("sortBy", sortByDefault);
            modelAndView.addObject("billList", billList);
            modelAndView.addObject("listPage", listPage);
            return modelAndView;
        }
    }
}
