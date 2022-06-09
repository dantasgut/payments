package br.com.lab.payments.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.lab.payments.api.dtos.PaymentDTO;
import br.com.lab.payments.api.dtos.PaymentTypeDTO;
import br.com.lab.payments.repositories.entities.Payment;
import br.com.lab.payments.repositories.entities.PaymentType;
import br.com.lab.payments.repositories.interfaces.PaymentRepository;
import br.com.lab.payments.repositories.interfaces.PaymentTypeRepository;
import br.com.lab.payments.services.interfaces.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	PaymentTypeRepository paymentTypeRepository;
	
	<S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	public List<PaymentDTO> findByStatus(String status, Integer page, Integer pageSize) {
		List<Payment> payments;
		
		if(page != null && pageSize !=null ) {
			Pageable paging = PageRequest.of(page, pageSize);
			payments = paymentRepository.findByStatus(status, paging);
		} else if(status!=null) {
			payments = paymentRepository.findByStatus(status);
		} else {
			payments = paymentRepository.find();
		}
		
		modelMapper.typeMap(Payment.class, PaymentDTO.class)
        .setPropertyCondition(context -> true).addMappings(mapper -> {
        	mapper.map(src-> src.getIdOrder(), PaymentDTO::setIdOrder);
			mapper.map(src-> src.getPaymentType(), PaymentDTO::setPaymentTypeDTO);
			
		});
		
		return mapList(payments, PaymentDTO.class);
	}

	public List<PaymentDTO> findByStatusAndOrder(String status, Integer idOrder, Integer page, Integer pageSize){
		List<Payment> payments;
		
		if(page != null && pageSize !=null ) {
			Pageable paging = PageRequest.of(page, pageSize);
			payments = paymentRepository.findByStatusAndOrder(status, idOrder, paging);
		} else if(status!=null) {
			payments = paymentRepository.findByStatusAndOrder(status, idOrder);
		} else {
			payments = paymentRepository.findByOrder(idOrder);
		}
		
		modelMapper.typeMap(Payment.class, PaymentDTO.class)
        .setPropertyCondition(context -> true).addMappings(mapper -> {
        	mapper.map(src-> src.getIdOrder(), PaymentDTO::setIdOrder);
			mapper.map(src-> src.getPaymentType(), PaymentDTO::setPaymentTypeDTO);
			
		});
		
		return mapList(payments, PaymentDTO.class);
	}	
	
	public PaymentDTO findById(PaymentDTO paymentDTO) {
		Payment payment = paymentRepository.findById(paymentDTO.getId()).orElse(new Payment());
		
		modelMapper.typeMap(Payment.class, PaymentDTO.class)
        .setPropertyCondition(context -> true).addMappings(mapper -> {
        	mapper.map(src-> src.getIdOrder(), PaymentDTO::setIdOrder);
			mapper.map(src-> src.getPaymentType(), PaymentDTO::setPaymentTypeDTO);
			
		});
		
		return modelMapper.map(payment, PaymentDTO.class);
	}
	
	public List<PaymentTypeDTO> findPaymentType() {
		List<PaymentType> paymentTypes = paymentTypeRepository.findAll();
		return mapList(paymentTypes, PaymentTypeDTO.class);
	}

	public void save(PaymentDTO paymentDTO) {
		Payment payment = modelMapper.map(paymentDTO, Payment.class);		
		paymentRepository.save(payment);
		
	}

	public void delete(PaymentDTO paymentDTO) {
		Payment payment = modelMapper.map(paymentDTO, Payment.class);
		paymentRepository.delete(payment);
	}

	

}
