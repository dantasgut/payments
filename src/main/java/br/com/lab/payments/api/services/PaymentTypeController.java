package br.com.lab.payments.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lab.payments.api.dtos.PaymentTypeDTO;
import br.com.lab.payments.services.interfaces.PaymentService;

@RestController
public class PaymentTypeController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/orders/payments/types")
	public List<PaymentTypeDTO> findAll(){
		return paymentService.findPaymentType();
	}
	
}
