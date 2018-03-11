package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product 
{
	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private String productDesc;
	
	public int getProductId() 
	{
		return productId;
	}
	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public String getProductDesc() 
	{
		return productDesc;
	}
	public void setProductDesc(String productDesc) 
	{
		this.productDesc = productDesc;
	}
}
