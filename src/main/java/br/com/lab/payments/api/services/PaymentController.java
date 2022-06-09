package br.com.lab.payments.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lab.payments.api.dtos.PaymentDTO;
import br.com.lab.payments.services.interfaces.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	@RequestMapping("/orders/payments")
	public List<PaymentDTO> findByStatus(
			@RequestParam(name="status", required=false) String status,
			@RequestParam(name="page", required=false) Integer page, 
			@RequestParam(name="pageSize", required=false)Integer pageSize){
		return paymentService.findByStatus(status, page, pageSize);
	}
	
	@GetMapping
	@RequestMapping("/orders/{idOrder}/payments")
	public List<PaymentDTO> findByStatusAndOrder(
			@PathVariable("idOrder") Integer idOrder,
			@RequestParam(name="status", required=false) String status,
			@RequestParam(name="page", required=false) Integer page, 
			@RequestParam(name="pageSize", required=false) Integer pageSize){
		return paymentService.findByStatusAndOrder(status, idOrder, page, pageSize);
	}
	
	@GetMapping(value = "/orders/{idOrder}/payments/{idPayment}")
	public PaymentDTO getById(@PathVariable("idOrder") Integer idOrder, @PathVariable("idPayment") Integer idPayment) {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setIdOrder(idOrder);
		paymentDTO.setId(idPayment);
		return paymentService.findById(paymentDTO);
	}
	
	@PostMapping(value="/orders/{idOrder}/payments")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@PathVariable("idOrder") Integer idOrder, @RequestBody PaymentDTO paymentDTO) {
		paymentDTO.setIdOrder(idOrder);
		paymentService.save(paymentDTO);
	}
	
	@PutMapping(value = "/orders/{idOrder}/payments/{idPayment}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("idOrder") Integer idOrder, @PathVariable("idPayment") Integer idPayment, @RequestBody PaymentDTO paymentDTO) {
		paymentDTO.setIdOrder(idOrder);
		paymentDTO.setId(idPayment);
		paymentService.save(paymentDTO);
	}
	
	@DeleteMapping(value = "/orders/{idOrder}/payments/{idPayment}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("idOrder") Integer idOrder,@PathVariable("idPayment") Integer idPayment) {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setIdOrder(idOrder);
		paymentDTO.setId(idPayment);
		paymentService.delete(paymentDTO);
	}
	
}
