package com.niit.DAO;

	import java.util.List;

	import com.niit.model.CartItem;

	public interface CartItemDAO {
		public boolean addCartItem(CartItem cartItem);
		public CartItem getCartItem(int CartItemId);
		public boolean updateCartItem(CartItem cartItem);
		public boolean deleteCartItem(CartItem cartItem);
		public List<CartItem> getCartItems(String username);
	}


