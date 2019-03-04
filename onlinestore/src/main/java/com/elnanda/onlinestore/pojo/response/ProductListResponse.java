package com.elnanda.onlinestore.pojo.response;

import java.util.List;

import lombok.Data;

import com.elnanda.onlinestore.dto.ProductDTO;

@Data
public class ProductListResponse {
	private List<ProductDTO> listProduct;

}
