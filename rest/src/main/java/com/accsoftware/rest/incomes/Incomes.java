package com.accsoftware.rest.incomes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.accsoftware.rest.income_cat.IncomeCat;

@Entity
public class Incomes {

	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
	name = "sequence-generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "incomes_sequence"),
			@Parameter(name = "initial_value", value= "1"),
			@Parameter(name = "increment_size", value = "1")
	})
	private Long id;
	private String name;
	private double amount;
	private String recieveby;
	private String remark;
	private Date date;
	
	@ManyToOne(optional = false)
	@JoinColumn(name =  "icat_id", referencedColumnName = "id")
	private IncomeCat ic;

	public Incomes() {
		this.name =  new String();
		this.recieveby =  new String();
		this.remark =  new String();
	}

	public Incomes(Long id, String name, double amount, String recieveby, String remark, Date date, IncomeCat ic) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.recieveby = recieveby;
		this.remark = remark;
		this.date = date;
		this.ic = ic;
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

	public IncomeCat getIc() {
		return ic;
	}

	public void setIc(IncomeCat ic) {
		this.ic = ic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((ic == null) ? 0 : ic.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recieveby == null) ? 0 : recieveby.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		Incomes other = (Incomes) obj;
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
		if (ic == null) {
			if (other.ic != null) {
				return false;
			}
		} else if (!ic.equals(other.ic)) {
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
		return true;
	}

	@Override
	public String toString() {
		return "Incomes [id=" + id + ", name=" + name + ", amount=" + amount + ", recieveby=" + recieveby + ", remark="
				+ remark + ", date=" + date + ", ic=" + ic + "]";
	}
}
