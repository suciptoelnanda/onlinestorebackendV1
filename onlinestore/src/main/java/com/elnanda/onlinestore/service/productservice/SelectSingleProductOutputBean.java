package com.elnanda.onlinestore.service.productservice;

import com.elnanda.onlinestore.dto.ProductDTO;

import lombok.Data;

@Data
public class SelectSingleProductOutputBean {
	private ProductDTO productDto;
	private String outputMessage;

}
