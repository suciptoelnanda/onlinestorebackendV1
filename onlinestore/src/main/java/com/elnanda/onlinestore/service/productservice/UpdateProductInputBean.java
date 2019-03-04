package com.elnanda.onlinestore.service.productservice;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UpdateProductInputBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productName;
	private MultipartFile[] imageUrl;
	private String productDesc;
	private BigDecimal productPrice;
	private Integer productId;

}
