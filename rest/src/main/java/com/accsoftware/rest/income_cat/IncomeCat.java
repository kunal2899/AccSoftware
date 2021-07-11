package com.accsoftware.rest.income_cat;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.accsoftware.rest.incomes.Incomes;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IncomeCat {

	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
	name = "sequence-generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "incomecat_sequence"),
			@Parameter(name = "initial_value", value= "1"),
			@Parameter(name = "increment_size", value = "1")
	})
	private Long id;
	private String name;
	private String details;
	private Long userId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ic",cascade = CascadeType.REMOVE)
	private List<Incomes> incomesList;

	public IncomeCat(Long id, String name, String details, List<Incomes> incomesList, Long userId) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.userId = userId;
		this.incomesList = incomesList;
	}

	public List<Incomes> getIncomesList() {
		return incomesList;
	}

	public void setIncomesList(List<Incomes> incomesList) {
		this.incomesList = incomesList;
	}

	public IncomeCat() {
		this.name = new String();
		this.details = new String();
	}

	public IncomeCat(Long id, String name, String details) {
		this.id = id;
		this.name = name;
		this.details = details;
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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((incomesList == null) ? 0 : incomesList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		IncomeCat other = (IncomeCat) obj;
		if (details == null) {
			if (other.details != null) {
				return false;
			}
		} else if (!details.equals(other.details)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (incomesList == null) {
			if (other.incomesList != null) {
				return false;
			}
		} else if (!incomesList.equals(other.incomesList)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
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
		return "IncomeCat [id=" + id + ", name=" + name + ", details=" + details + ", userId=" + userId
				+ ", incomesList=" + incomesList + "]";
	}
}
