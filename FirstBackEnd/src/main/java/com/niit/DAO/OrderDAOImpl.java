package com.niit.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.OrderDetail;
@Repository("orderDetailDAO")

public class OrderDAOImpl implements  OrderDAO
{
   @Autowired
   SessionFactory sessionFactory;
   
   @Transactional
   public boolean confrimOrderDetail(OrderDetail orderDetail) 
   {
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
