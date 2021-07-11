package com.accsoftware.rest.user;

public class UpdateDTO {
	private Long id;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String username;
	private String curr_password;
	private String new_password;
	private String entered_password;

	
	
	@Override
	public String toString() {
		return "UpdateDTO [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + ", username=" + username + ", curr_password=" + curr_password + ", new_password="
				+ new_password + ", entered_password=" + entered_password + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((curr_password == null) ? 0 : curr_password.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((entered_password == null) ? 0 : entered_password.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((new_password == null) ? 0 : new_password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UpdateDTO other = (UpdateDTO) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (curr_password == null) {
			if (other.curr_password != null) {
				return false;
			}
		} else if (!curr_password.equals(other.curr_password)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (entered_password == null) {
			if (other.entered_password != null) {
				return false;
			}
		} else if (!entered_password.equals(other.entered_password)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (mobile == null) {
			if (other.mobile != null) {
				return false;
			}
		} else if (!mobile.equals(other.mobile)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (new_password == null) {
			if (other.new_password != null) {
				return false;
			}
		} else if (!new_password.equals(other.new_password)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getCurr_password() {
		return curr_password;
	}



	public void setCurr_password(String curr_password) {
		this.curr_password = curr_password;
	}



	public String getNew_password() {
		return new_password;
	}



	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}



	public String getEntered_password() {
		return entered_password;
	}



	public void setEntered_password(String entered_password) {
		this.entered_password = entered_password;
	}
	
	public User getUser() {
		return new User(this.id,this.name,this.address,this.mobile,this.email,this.username,this.curr_password,false);
	}



	public UpdateDTO() {
		this.name = new String();
		this.address = new String();
		this.mobile = new String();
		this.email = new String();
		this.username = new String();
		this.curr_password = new String();
		this.entered_password = new String();
		this.new_password = new String();
	}

	public UpdateDTO(Long id, String name, String address, String mobile, String email, String username,
			String curr_password, String new_password,String entered_password) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.curr_password = curr_password;
		this.new_password = new_password;
		this.entered_password = entered_password;
	}
}
