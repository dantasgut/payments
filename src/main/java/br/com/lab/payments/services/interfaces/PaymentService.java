package br.com.lab.payments.services.interfaces;

import java.util.List;

import br.com.lab.payments.api.dtos.PaymentDTO;
import br.com.lab.payments.api.dtos.PaymentTypeDTO;

public interface PaymentService {
	public PaymentDTO findById(PaymentDTO productDTO);
	public List<PaymentDTO> findByStatus(String status, Integer page, Integer pageSize);	
	public List<PaymentDTO> findByStatusAndOrder(String status, Integer idOrder, Integer page, Integer pageSize);	
	public List<PaymentTypeDTO> findPaymentType();
	public void save(PaymentDTO productDTO);
	public void delete(PaymentDTO productDTO);

}
