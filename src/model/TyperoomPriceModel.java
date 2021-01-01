package model;

public class TyperoomPriceModel {
	private String typeId;
	private String monthInYear;
	private int hourWeekdayPrice;
	private int hourWeekendPrice;
	private int dayWeekdayPrice;
	private int dayWeekendPrice;
	private int monthPrice;
	
	public TyperoomPriceModel(String typeId, String monthInYear, int hourWeekdayPrice, int hourWeekendPrice,
			int dayWeekdayPrice, int dayWeekendPrice, int monthPrice) {
		super();
		this.typeId = typeId;
		this.monthInYear = monthInYear;
		this.hourWeekdayPrice = hourWeekdayPrice;
		this.hourWeekendPrice = hourWeekendPrice;
		this.dayWeekdayPrice = dayWeekdayPrice;
		this.dayWeekendPrice = dayWeekendPrice;
		this.monthPrice = monthPrice;
	}

	public String getTypeId() {
		return typeId;
	}

	public String getMonthInYear() {
		return monthInYear;
	}

	public int getHourWeekdayPrice() {
		return hourWeekdayPrice;
	}

	public int getHourWeekendPrice() {
		return hourWeekendPrice;
	}

	public int getDayWeekdayPrice() {
		return dayWeekdayPrice;
	}

	public int getDayWeekendPrice() {
		return dayWeekendPrice;
	}

	public int getMonthPrice() {
		return monthPrice;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public void setMonthInYear(String monthInYear) {
		this.monthInYear = monthInYear;
	}

	public void setHourWeekdayPrice(int hourWeekdayPrice) {
		this.hourWeekdayPrice = hourWeekdayPrice;
	}

	public void setHourWeekendPrice(int hourWeekendPrice) {
		this.hourWeekendPrice = hourWeekendPrice;
	}

	public void setDayWeekdayPrice(int dayWeekdayPrice) {
		this.dayWeekdayPrice = dayWeekdayPrice;
	}

	public void setDayWeekendPrice(int dayWeekendPrice) {
		this.dayWeekendPrice = dayWeekendPrice;
	}

	public void setMonthPrice(int monthPrice) {
		this.monthPrice = monthPrice;
	}
	
	
}
