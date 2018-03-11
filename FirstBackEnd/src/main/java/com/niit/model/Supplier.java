package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier 
{
	@Id
	@GeneratedValue
	private int supplierId;
	private String supplierName;
	private String supplierDesc;
	
	public int getSupplierId() 
	{
		return supplierId;
	}
	public void setSupplierId(int categoryId) 
	{
		this.supplierId = categoryId;
	}
	public String getSupplierName() 
	{
		return supplierName;
	}
	public void setSupplierName(String categoryName) 
	{
		this.supplierName = categoryName;
	}
	public String getSupplierDesc() 
	{
		return supplierDesc;
	}
	public void setSupplierDesc(String cateogryDesc) 
	{
		this.supplierDesc = cateogryDesc;
	}
}