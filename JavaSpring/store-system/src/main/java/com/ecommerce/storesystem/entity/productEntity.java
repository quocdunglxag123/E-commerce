package com.ecommerce.storesystem.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class productEntity extends BaseEntity {
	private String name;
	
	private BigDecimal  price;

	private BigDecimal  discount;
	
	private String unit;
	
	private String image;
	
	private String description;
	
	private int productWarranty;

	private Boolean status;

	private String ram;
	
	private String rom;
	
	private String screen;
	
	private String battery;
	
	private String os;
	
	private String camera;
	
	private String color;

	
	public productEntity() {
		super();
	}


	public productEntity(String name, BigDecimal price, BigDecimal discount, String unit, String image,
			String description, int productWarranty, Boolean status, String ram, String rom, String screen,
			String battery, String os, String camera, String color) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.unit = unit;
		this.image = image;
		this.description = description;
		this.productWarranty = productWarranty;
		this.status = status;
		this.ram = ram;
		this.rom = rom;
		this.screen = screen;
		this.battery = battery;
		this.os = os;
		this.camera = camera;
		this.color = color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BigDecimal getDiscount() {
		return discount;
	}


	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getProductWarranty() {
		return productWarranty;
	}


	public void setProductWarranty(int productWarranty) {
		this.productWarranty = productWarranty;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getRam() {
		return ram;
	}


	public void setRam(String ram) {
		this.ram = ram;
	}


	public String getRom() {
		return rom;
	}


	public void setRom(String rom) {
		this.rom = rom;
	}


	public String getScreen() {
		return screen;
	}


	public void setScreen(String screen) {
		this.screen = screen;
	}


	public String getBattery() {
		return battery;
	}


	public void setBattery(String battery) {
		this.battery = battery;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	public String getCamera() {
		return camera;
	}


	public void setCamera(String camera) {
		this.camera = camera;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

}
