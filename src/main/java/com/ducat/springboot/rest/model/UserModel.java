package com.ducat.springboot.rest.model;

public class UserModel {
	
		private String status;

		public UserModel(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
}


