package com.fdmgroup.bookstore.exception;

	public class ItemNotFoundException extends Exception {
		
		public ItemNotFoundException () {
			super("Item not found!");
		}

	}
