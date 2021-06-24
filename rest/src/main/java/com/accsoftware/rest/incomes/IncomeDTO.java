package com.accsoftware.rest.incomes;

import java.util.Date;

public class IncomeDTO {

	private Long id;
	private String name;
	private int amount;
	private String recieveby;						
	private String remark;
	private Date date;
	private Long incCatId;
	private Long userId;
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRecieveby() {
		return recieveby;
	}
	public void setRecieveby(String recieveby) {
		this.recieveby = recieveby;
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
	public Long getIncCatId() {
		return incCatId;
	}
	public void setIncCatId(Long expCatId) {
		this.incCatId = expCatId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public IncomeDTO(Long id, String name, int amount, String recieveby, String remark, Date date, Long expCatId,
			Long userId) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.recieveby = recieveby;
		this.remark = remark;
		this.date = date;
		this.incCatId = expCatId;
		this.userId = userId;
	}
	
	public IncomeDTO() {
		this.name = new String();
		this.recieveby = new String();
		this.remark = new String();
		this.date = new Date();
	}
	
	public Incomes getIncome() {
		return new Incomes(id,name,amount,recieveby,remark,date,null,userId);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((incCatId == null) ? 0 : incCatId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recieveby == null) ? 0 : recieveby.hashCode());
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
		IncomeDTO other = (IncomeDTO) obj;
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
		if (incCatId == null) {
			if (other.incCatId != null) {
				return false;
			}
		} else if (!incCatId.equals(other.incCatId)) {
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
		if (recieveby == null) {
			if (other.recieveby != null) {
				return false;
			}
		} else if (!recieveby.equals(other.recieveby)) {
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
		return "IncomeDTO [id=" + id + ", name=" + name + ", amount=" + amount + ", recieveby=" + recieveby
				+ ", remark=" + remark + ", date=" + date + ", expCatId=" + incCatId + ", userId=" + userId + "]";
	}
}
