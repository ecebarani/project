package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierUnitTest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("venilla icecream");
		supplier.setSupplierDesc("sweet and delicious");
		assertTrue("Problem in Supplier Insertion",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Supplier",supplierDAO.getSupplier(1));
	}
	
	
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(33);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}

	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
		supplier.setSupplierId(1);
		supplier.setSupplierName("milky bar");
		supplier.setSupplierDesc("so sweet");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		assertNotNull("No Suppliers",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getSupplierId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierDesc());
		}
	}
}