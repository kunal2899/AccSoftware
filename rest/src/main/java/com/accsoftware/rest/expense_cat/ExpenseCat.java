package com.accsoftware.rest.expense_cat;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.accsoftware.rest.expenses.Expenses;

@Entity
public class ExpenseCat {
	
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
	name = "sequence-generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
			@Parameter(name = "sequence_name", value = "user_sequence"),
			@Parameter(name = "initial_value", value= "1"),
			@Parameter(name = "increment_size", value = "1")
	})
	private Long id;
	private String name;
	private String details;
	private Long userId;
	
	@OneToMany(mappedBy = "ec")
	List<Expenses> expensesList;
	
	public ExpenseCat() {
		this.name = new String();
		this.details = new String();
	}

	public ExpenseCat(Long id, String name, String details) {
		this.id = id;
		this.name = name;
		this.details = details;
	}

	public ExpenseCat(Long id, String name, String details, List<Expenses> expensesList, Long userId) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.userId = userId;
		this.expensesList = expensesList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Expenses> getExpensesList() {
		return expensesList;
	}

	public void setExpensesList(List<Expenses> expensesList) {
		this.expensesList = expensesList;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((expensesList == null) ? 0 : expensesList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ExpenseCat other = (ExpenseCat) obj;
		if (details == null) {
			if (other.details != null) {
				return false;
			}
		} else if (!details.equals(other.details)) {
			return false;
		}
		if (expensesList == null) {
			if (other.expensesList != null) {
				return false;
			}
		} else if (!expensesList.equals(other.expensesList)) {
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
		return "ExpenseCat [id=" + id + ", name=" + name + ", details=" + details + ", userId=" + userId
				+ ", expensesList=" + expensesList + "]";
	}
}
