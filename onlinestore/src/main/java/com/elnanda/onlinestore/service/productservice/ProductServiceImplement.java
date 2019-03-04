package com.elnanda.onlinestore.service.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elnanda.onlinestore.dto.ProductDTO;
import com.elnanda.onlinestore.model.MasterProduct;
import com.elnanda.onlinestore.repository.MasterProductRepository;
import com.elnanda.onlinestore.util.FileServiceUtil;

@Service
public class ProductServiceImplement implements ProductService {

	@Autowired
	MasterProductRepository masterProductRepo;

	@Autowired
	FileServiceUtil imageUtil;

	@Override
	public GetListProductServiceOutputbean getListProduct(GetListProductServiceInputBean input) {
		GetListProductServiceOutputbean output = new GetListProductServiceOutputbean();
		List<MasterProduct> listMasterProduct = masterProductRepo.findAll();
		List<ProductDTO> listProductDto = new ArrayList<ProductDTO>();

		if (!listMasterProduct.isEmpty()) {
			for (MasterProduct dataProduct : listMasterProduct) {
				ProductDTO productDto = new ProductDTO();
				productDto.setProductName(dataProduct.getName());
				productDto.setProductPrice(dataProduct.getPrice());
				productDto.setUrlImage(dataProduct.getImage());
				productDto.setProductDesc(dataProduct.getDescription());
				productDto.setProductId(dataProduct.getId());
				listProductDto.add(productDto);

			}
		}

		output.setListProduct(listProductDto);
		return output;
	}

	@Override
	public SaveNewProductOutputBean save(SaveNewProductInputBean input) {
		SaveNewProductOutputBean output = new SaveNewProductOutputBean();
		try {

			String imageFileName = imageUtil.processImage(input.getImageUrl()[0]);

			MasterProduct masterProduct = new MasterProduct();
			masterProduct.setName(input.getProductName());
			masterProduct.setImage(imageFileName);
			masterProduct.setPrice(input.getProductPrice());
			masterProduct.setDescription(input.getProductDesc());
			masterProductRepo.save(masterProduct);

			output.setMessage("New Product Successfully inputted");
		} catch (Exception e) {
			output.setMessage("Failed to input new product");
		}

		return output;
	}

	@Override
	public DeleteProductOutputBean delete(DeleteProductInputBean input) {
		DeleteProductOutputBean output = new DeleteProductOutputBean();
		try {
			masterProductRepo.deleteById(input.getProductId());
			output.setMessage("Product successfully deleted");
		} catch (Exception e) {
			output.setMessage("Failed to delete product");
		}
		return output;
	}

	@Override
	public UpdateProductOutputBean update(UpdateProductInputBean input) {
		UpdateProductOutputBean output = new UpdateProductOutputBean();
		try {

			MasterProduct masterProduct = masterProductRepo.getOne(input.getProductId());
			masterProduct.setName(input.getProductName());
			masterProduct.setPrice(input.getProductPrice());
			masterProductRepo.save(masterProduct);
			output.setMessage("Product successfully updated");

		} catch (Exception e) {
			output.setMessage("Product successfully updated");
		}
		return output;
	}

	@Override
	public SelectSingleProductOutputBean selectProductDetailById(SelectSingleProductInputBean input) {
		SelectSingleProductOutputBean output = new SelectSingleProductOutputBean();
		try {
			MasterProduct dataProduct = masterProductRepo.getOne(input.getProductId());
			ProductDTO productDto = new ProductDTO();
			productDto.setProductName(dataProduct.getName());
			productDto.setProductPrice(dataProduct.getPrice());
			productDto.setUrlImage(dataProduct.getImage());
			productDto.setProductDesc(dataProduct.getDescription());
			output.setProductDto(productDto);
		} catch (Exception e) {
			output.setOutputMessage("Get single data failed");
		}
		return output;
	}

}
