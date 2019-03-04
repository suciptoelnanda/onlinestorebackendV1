package com.elnanda.onlinestore.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;

import javax.activation.FileTypeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elnanda.onlinestore.pojo.response.DeleteProductResponse;
import com.elnanda.onlinestore.pojo.response.ProductDetailResponse;
import com.elnanda.onlinestore.pojo.response.ProductListResponse;
import com.elnanda.onlinestore.pojo.response.SaveNewProductResponse;
import com.elnanda.onlinestore.pojo.response.UpdateProductResponse;
import com.elnanda.onlinestore.service.productservice.DeleteProductInputBean;
import com.elnanda.onlinestore.service.productservice.DeleteProductOutputBean;
import com.elnanda.onlinestore.service.productservice.GetListProductServiceInputBean;
import com.elnanda.onlinestore.service.productservice.GetListProductServiceOutputbean;
import com.elnanda.onlinestore.service.productservice.ProductService;
import com.elnanda.onlinestore.service.productservice.SaveNewProductInputBean;
import com.elnanda.onlinestore.service.productservice.SaveNewProductOutputBean;
import com.elnanda.onlinestore.service.productservice.SelectSingleProductInputBean;
import com.elnanda.onlinestore.service.productservice.SelectSingleProductOutputBean;
import com.elnanda.onlinestore.service.productservice.UpdateProductInputBean;
import com.elnanda.onlinestore.service.productservice.UpdateProductOutputBean;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@CrossOrigin
	@RequestMapping(value = "/listproduct", method = RequestMethod.POST)
	public ResponseEntity<ProductListResponse> getListProduct() {

		ProductListResponse response = new ProductListResponse();
		GetListProductServiceInputBean input = new GetListProductServiceInputBean();

		GetListProductServiceOutputbean output = productService.getListProduct(input);
		response.setListProduct(output.getListProduct());

		return new ResponseEntity<ProductListResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/addnewproduct", method = RequestMethod.POST)
	public ResponseEntity<SaveNewProductResponse> saveNewProduct(@RequestParam("urlImage") MultipartFile[] urlImage, @RequestParam("productName") String productName,
			@RequestParam("productDesc") String productDesc, @RequestParam("productPrice") BigDecimal productPrice) {
		SaveNewProductResponse response = new SaveNewProductResponse();

		SaveNewProductInputBean input = new SaveNewProductInputBean();
		input.setProductName(productName);
		input.setImageUrl(urlImage);
		input.setProductDesc(productDesc);
		input.setProductPrice(productPrice);

		SaveNewProductOutputBean output = productService.save(input);
		response.setMessage(output.getMessage());

		return new ResponseEntity<SaveNewProductResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
	public ResponseEntity<UpdateProductResponse> updateProduct(@RequestParam("productName") String productName, @RequestParam("productPrice") BigDecimal productPrice, @RequestParam("productId") Integer productId) {
		UpdateProductResponse response = new UpdateProductResponse();

		UpdateProductInputBean input = new UpdateProductInputBean();
		input.setProductName(productName);
		input.setProductPrice(productPrice);
		input.setProductId(productId);

		UpdateProductOutputBean output = productService.update(input);
		response.setMessage(output.getMessage());

		return new ResponseEntity<UpdateProductResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/selectbyid/{productid}", method = RequestMethod.POST)
	public ResponseEntity<ProductDetailResponse> detailProductbyId(@PathVariable("productid") Integer productId) {
		ProductDetailResponse response = new ProductDetailResponse();

		SelectSingleProductInputBean input = new SelectSingleProductInputBean();
		input.setProductId(productId);
		SelectSingleProductOutputBean output = productService.selectProductDetailById(input);
		response.setProductDetail(output.getProductDto());

		return new ResponseEntity<ProductDetailResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/deleteproduct/{productid}", method = RequestMethod.POST)
	public ResponseEntity<DeleteProductResponse> deleteProductById(@PathVariable("productid") Integer productId) {
		DeleteProductResponse response = new DeleteProductResponse();

		DeleteProductInputBean input = new DeleteProductInputBean();
		input.setProductId(productId);

		DeleteProductOutputBean output = productService.delete(input);
		response.setMessage(output.getMessage());

		return new ResponseEntity<DeleteProductResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/image/{productid}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("productid") Integer productId) throws IOException {

		SelectSingleProductInputBean input = new SelectSingleProductInputBean();
		input.setProductId(productId);

		SelectSingleProductOutputBean output = productService.selectProductDetailById(input);
		File image = new File("src/main/resources/static/" + output.getProductDto().getUrlImage());

		return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(image))).body(Files.readAllBytes(image.toPath()));

	}
}
