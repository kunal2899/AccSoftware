package com.accsoftware.rest.bank_book;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankBook {
	
	@Id
	private Long id;
	private Date date;
	private double amount;
	private String mode;
	
	
	public BankBook(Date date, double amount, String mode) {
		this.date = date;
		this.amount = amount;
		this.mode = mode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BankBook other = (BankBook) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (mode == null) {
			if (other.mode != null) {
				return false;
			}
		} else if (!mode.equals(other.mode)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "BankBook [id=" + id + ", date=" + date + ", amount=" + amount + ", mode=" + mode + "]";
	}

}
