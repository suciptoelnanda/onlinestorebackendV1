package com.elnanda.onlinestore.service.productservice;

public interface ProductService {

	public GetListProductServiceOutputbean getListProduct(GetListProductServiceInputBean input);

	public SaveNewProductOutputBean save(SaveNewProductInputBean input);

	public DeleteProductOutputBean delete(DeleteProductInputBean input);
	
	public UpdateProductOutputBean update (UpdateProductInputBean input);
	
	public SelectSingleProductOutputBean selectProductDetailById  (SelectSingleProductInputBean input);

}
