package com.accsoftware.rest.expenses;

import java.util.Date;

public class ExpensesDTO {
	
	private Long id;
	private String name;
	private int amount;
	private String payby;						
	private String remark;
	private Date date;
	private Long expCatId;
	private Long userId;
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPayby() {
		return payby;
	}
	public void setPayby(String payby) {
		this.payby = payby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getExpCatId() {
		return expCatId;
	}
	public void setExpCatId(Long expCatId) {
		this.expCatId = expCatId;
	}
	
	public ExpensesDTO(Long id, String name, int amount, String payby, String remark, Date date, Long expCatId,
			Long userId) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.payby = payby;
		this.remark = remark;
		this.date = date;
		this.expCatId = expCatId;
		this.userId = userId;
	}
	public ExpensesDTO() {
		this.name = new String();
		this.payby = new String();
		this.remark = new String();
		this.date = new Date();
	}
	
	public Expenses getExpense() {
		return new Expenses(id,name,amount,payby,remark,date,userId,null);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((expCatId == null) ? 0 : expCatId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((payby == null) ? 0 : payby.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		ExpensesDTO other = (ExpensesDTO) obj;
		if (amount != other.amount) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (expCatId == null) {
			if (other.expCatId != null) {
				return false;
			}
		} else if (!expCatId.equals(other.expCatId)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (payby == null) {
			if (other.payby != null) {
				return false;
			}
		} else if (!payby.equals(other.payby)) {
			return false;
		}
		if (remark == null) {
			if (other.remark != null) {
				return false;
			}
		} else if (!remark.equals(other.remark)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "ExpensesDTO [id=" + id + ", name=" + name + ", amount=" + amount + ", payby=" + payby + ", remark="
				+ remark + ", date=" + date + ", expCatId=" + expCatId + ", userId=" + userId + "]";
	}
	
}
