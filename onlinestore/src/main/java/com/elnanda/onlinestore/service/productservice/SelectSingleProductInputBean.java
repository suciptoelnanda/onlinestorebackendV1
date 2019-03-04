package com.elnanda.onlinestore.service.productservice;

import java.io.Serializable;

import lombok.Data;

@Data
public class SelectSingleProductInputBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer productId;

}
