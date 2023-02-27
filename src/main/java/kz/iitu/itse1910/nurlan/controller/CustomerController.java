package kz.iitu.itse1910.nurlan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.itse1910.nurlan.model.Customers;
import kz.iitu.itse1910.nurlan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/customers")
@Api(value = "a", tags = "Customer Controller", description = "Allows to work with customers data")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/listOfCustomers")
    @ApiOperation(value = "Get all customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customers> getAllCustomers() {
        return customerService.getallCustomers();
    }

    @RequestMapping("/customers")
    public ModelAndView allCustomer() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("customers", customerService.getallCustomers());
        mv.setViewName("customers");
        return mv;
    }

    @GetMapping("/customers/new")
    public String createCustomerForm(Model model) {
        Customers customers = new Customers();
        model.addAttribute("customer", customers);
        return "create_customer";
    }

    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customers customers) {
        customerService.addCustomer(customers);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable int id,
                                   Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable int id,
                                 @ModelAttribute("customer")
                                 Customers customers,
                                 Model model) {

        Customers existingCustomers = customerService.findById(id);

        existingCustomers.setCustomer_id(id);
        existingCustomers.setFirstname(customers.getFirstname());
        existingCustomers.setLastname(customers.getLastname());
        existingCustomers.setAddress(customers.getAddress());
        existingCustomers.setCity(customers.getCity());
        existingCustomers.setPhoneno(customers.getPhoneno());

        customerService.updateCustomerById(customers);
        return "redirect:/customers";
    }

    @GetMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @PostMapping("/addCustomer")
    @ApiOperation(value = "Add a new customer")
    public ResponseEntity<Void> addCustomer(@RequestBody @Valid Customers customers) {
        customerService.addCustomer(customers);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    @ApiOperation(value = "Update customer by id ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer was updated"),
            @ApiResponse(code = 304, message = "Customer was not modified")})
    @ResponseBody
    public ResponseEntity<Customers> updateCustomer(@RequestBody @Valid Customers customers) {
        try {
            customerService.updateCustomerById(customers);
            return new ResponseEntity<Customers>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Customers>(customers, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @ApiOperation(value = "Delete Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 410, message = "Deleted")})
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptions() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
                .build();
    }
}
