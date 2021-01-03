package model;

public class Book_ServiceModel {
	private String bookId;
	private String serviceId;
	private int serviceQuantity;
	
	public Book_ServiceModel(String bookId, String serviceId, int serviceQuantity) {
		super();
		this.bookId = bookId;
		this.serviceId = serviceId;
		this.serviceQuantity = serviceQuantity;
	}

	public String getBookId() {
		return bookId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public int getServiceQuantity() {
		return serviceQuantity;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public void setServiceQuantity(int serviceQuantity) {
		this.serviceQuantity = serviceQuantity;
	}
	
	
}
