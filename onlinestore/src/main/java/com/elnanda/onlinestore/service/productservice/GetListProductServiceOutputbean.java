package com.elnanda.onlinestore.service.productservice;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import com.elnanda.onlinestore.dto.ProductDTO;

@Data
public class GetListProductServiceOutputbean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProductDTO> listProduct;

}
