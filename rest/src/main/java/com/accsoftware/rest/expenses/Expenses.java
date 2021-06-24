package com.accsoftware.rest.expenses;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.accsoftware.rest.expense_cat.ExpenseCat;


@Entity
public class Expenses {

	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
	name = "sequence-generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "expenses_sequence"),
			@Parameter(name = "initial_value", value= "1"),
			@Parameter(name = "increment_size", value = "1")
	})
	private Long id;
	private String name;
	private double amount;
	private String payby;						//A for Cash & B for cheque
	private String remark;
	private Date date;
	private Long userId;
	

	@ManyToOne(optional = false)
	@JoinColumn(name =  "ecat_id", referencedColumnName = "id")
	private ExpenseCat ec;
	
	public ExpenseCat getEc() {
		return ec;
	}

	public void setEc(ExpenseCat ec) {
		this.ec = ec;
	}

	public Expenses() {
		this.name =  new String();
		this.payby =  new String();
		this.remark =  new String();
		this.date = new Date();
	}


	public Expenses(Long id, String name, double amount, String payby, String remark, Date date, Long userId,
			ExpenseCat ec) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.payby = payby;
		this.remark = remark;
		this.date = date;
		this.userId = userId;
		this.ec = ec;
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

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public void setDate(Date	 date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((ec == null) ? 0 : ec.hashCode());
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
		Expenses other = (Expenses) obj;
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
		if (ec == null) {
			if (other.ec != null) {
				return false;
			}
		} else if (!ec.equals(other.ec)) {
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
		return "Expenses [id=" + id + ", name=" + name + ", amount=" + amount + ", payby=" + payby + ", remark="
				+ remark + ", date=" + date + ", userId=" + userId + ", ec=" + ec + "]";
	}

	}
