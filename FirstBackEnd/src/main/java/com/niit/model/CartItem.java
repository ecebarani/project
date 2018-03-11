package com.niit.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int CartItemId;
private int CartId;
private String UserName;
private Product productId;
private int Quantity;
private int Subtotal;
private String PaymentStatus;

public int getCartItemId() {
	return CartItemId;
}
public void setCartItemId(int cartItemId) {
	CartItemId = cartItemId;
}
public int getCartId() {
	return CartId;
}
public void setCartId(int cartId) {
	CartId = cartId;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public Product getProductId() {
	return productId;
}
public void setProductId(Product productId) {
	this.productId = productId;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public int getSubtotal() {
	return Subtotal;
}
public void setSubtotal(int subtotal) {
	Subtotal = subtotal;
}
public String getPaymentStatus() {
	return PaymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	PaymentStatus = paymentStatus;
}

}

