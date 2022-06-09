package br.com.lab.payments.api.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDTO {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("paymentType")
	private PaymentTypeDTO paymentTypeDTO;
	
	@JsonProperty("date")
	private LocalDateTime date;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("value")
	private Double value;
	
	private Integer idOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public PaymentTypeDTO getPaymentTypeDTO() {
		return paymentTypeDTO;
	}

	public void setPaymentTypeDTO(PaymentTypeDTO paymentTypeDTO) {
		this.paymentTypeDTO = paymentTypeDTO;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	
	

}
