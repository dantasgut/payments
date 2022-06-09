package br.com.lab.payments.repositories.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author klass
 *
 */
@Entity
@Table(name="tb_payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "sq_payments")	
	@TableGenerator(name = "sq_payments", table = "tb_sequences", pkColumnName = "name", valueColumnName = "value", pkColumnValue="sq_payments")
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_payment_type")
	private PaymentType paymentType;
	
	@Column(name="date")
	private LocalDateTime date;
	
	@Column(name="status")
	private String status;
	
	@Column(name="value")
	private Double value;
	
	@Column(name="id_order")
	private Integer idOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
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
