//package kz.iitu.itse1910.nurlan.oibekuly.controller;
//
//import kz.iitu.itse1910.nurlan.oibekuly.model.Customers;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.ui.Model;
//
//@Controller
//@RequestMapping("admin")
//public class AdminController {
//
//    @GetMapping("index")
//    public String index() {
//        return "admin/index";
//    }
//
//    public String registerCustomer(Model model) {
//        Customers customers = new Customers();
//        model.addAttribute("customer", customers);
//        return "create_customer";
//    }
//}
