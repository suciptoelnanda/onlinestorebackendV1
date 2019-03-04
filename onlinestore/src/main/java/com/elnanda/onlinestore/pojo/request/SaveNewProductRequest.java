package com.elnanda.onlinestore.pojo.request;

import java.math.BigDecimal;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

@Data
public class SaveNewProductRequest {
	private String productName;
	private String productDesc;
	private MultipartFile[] urlImage;
	private BigDecimal productPrice;

}
