package com.niit.test;

import static org.junit.Assert.*;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.model.Product;

public class ProductUnitTest 
{
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(3);
		product.setProductName("watches");
		product.setProductDesc("fastrack watches");
		assertTrue("Problem in Product Insertion",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Product",productDAO.getProduct(1));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(1);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}

	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(1);
		product.setProductId(1);
		product.setProductName("Rolex");
		product.setProductDesc("costliest and stylish");
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Ignore
	@Test
	public void listProductsTest()
	{
		List<Product> listProducts=productDAO.getProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getProductDesc());
		}
	}
}