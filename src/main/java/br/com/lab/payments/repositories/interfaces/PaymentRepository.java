package br.com.lab.payments.repositories.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.lab.payments.repositories.entities.Payment;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Integer>, JpaSpecificationExecutor<Payment>{
	
	@Query("select distinct p from Payment p inner join p.paymentType pt where p.status=:status order by p.idOrder")
	public List<Payment> findByStatus(@Param("status") String status, Pageable paging);
	
	@Query("select distinct p from Payment p inner join p.paymentType pt where p.status=:status order by p.idOrder")
	public List<Payment> findByStatus(@Param("status") String status);
	
	@Query("select distinct p from Payment p inner join p.paymentType pt order by p.idOrder")
	public List<Payment> find();
	
	@Query("select distinct p from Payment p inner join p.paymentType pt where p.idOrder=:idOrder order by p.idOrder")
	public List<Payment> findByOrder(@Param("idOrder") Integer idOrder, Pageable paging);
	
	@Query("select distinct p from Payment p inner join p.paymentType pt where p.idOrder=:idOrder and p.status=:status order by p.idOrder")
	public List<Payment> findByStatusAndOrder(@Param("status") String status, @Param("idOrder") Integer idOrder, Pageable paging);
	
	@Query("select distinct p from Payment p inner join p.paymentType pt where p.idOrder=:idOrder order by p.idOrder")
	public List<Payment> findByOrder(@Param("idOrder") Integer idOrder);
	
	@Query("select distinct p from Payment p inner join p.paymentType pt where p.idOrder=:idOrder and p.status=:status order by p.idOrder")
	public List<Payment> findByStatusAndOrder(@Param("status") String status, @Param("idOrder") Integer idOrder);
}
