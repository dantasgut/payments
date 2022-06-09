package br.com.lab.payments.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentTypeDTO {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("type")
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
