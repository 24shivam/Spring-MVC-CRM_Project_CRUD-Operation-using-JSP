package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/list")
	public String ListCustomer(Map<String, Object> model) {
		System.out.println("Implementationclass is::" + service.getClass().getName());
		List<Customer> customers = service.getCustomer();

		customers.forEach(System.out::println);
		model.put("customers", customers);
		return "list-customer";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Map<String, Object> model) {

		Customer customer = new Customer();
		model.put("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		service.saveCustomer(customer);
		System.out.println(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam Integer customerId, Map<String, Object> model) {
		Customer customer = service.getCustomer(customerId);
		model.put("customer", customer);
		return "customer-form";
	}

	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam Integer customerId) {
		
		service.deleteCustomer(customerId);
		return "redirect:/customer/list";
		
	}

}
