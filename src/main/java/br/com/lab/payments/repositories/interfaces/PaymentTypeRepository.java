package br.com.lab.payments.repositories.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.lab.payments.repositories.entities.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
	
	@Query("select p from PaymentType p")
	public List<PaymentType> findAll();
}
