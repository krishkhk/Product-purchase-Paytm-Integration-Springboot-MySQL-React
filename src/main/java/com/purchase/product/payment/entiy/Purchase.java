package com.purchase.product.payment.entiy;

import java.time.LocalDateTime;
import java.util.UUID;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "purchase")
public class Purchase {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String orderId;

	private String Item;

	private Integer quantity;

	private Double unitPrice;

	private Double subTotal;
	
	@NotEmpty(message = "Email require !")
	@jakarta.validation.constraints.Email(message = "Invalid Email Format")
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime orderDateandTime;

	public Purchase() {
		this.orderId = UUID.randomUUID().toString();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItem() {
		return Item;
	}

	public void setItem(String item) {
		Item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public LocalDateTime getOrderDateandTime() {
		return orderDateandTime;
	}

	public void setOrderDateandTime(LocalDateTime orderDateandTime) {
		this.orderDateandTime = orderDateandTime;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	

}
