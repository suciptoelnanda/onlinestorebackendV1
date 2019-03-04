package com.elnanda.onlinestore.pojo.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpdateProductRequest {
	private String productName;
	private String productDesc;
	private String urlImage;
	private BigDecimal productPrice;
	private Integer productId;

}
