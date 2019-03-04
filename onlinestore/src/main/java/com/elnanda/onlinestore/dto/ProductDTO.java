package com.elnanda.onlinestore.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDTO {
	
	private String productName;
	private String productDesc;
	private String urlImage;
	private BigDecimal productPrice;
	private Integer productId;
	

}
