package br.com.gomes.appfinance.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_users;
        @Email
        private String email;
        private String password;
        @NotBlank
        private String address_1;

        private String address_2;
        @NotBlank
        private String city;
        @NotBlank
        private String state;
        @NotBlank
        private String zip;
        private Date date;
        public Users() {

        }

        public Users(String email, String password, String address_1, String address_2, String city, String state, String zip, Date date) {
                this.email = email;
                this.password = password;
                this.address_1 = address_1;
                this.address_2 = address_2;
                this.city = city;
                this.state = state;
                this.zip = zip;
                this.date = date;
        }

        public Long getId_users() {
                return id_users;
        }

        public void setId_users(Long id_users) {
                this.id_users = id_users;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getAddress_1() {
                return address_1;
        }

        public void setAddress_1(String address_1) {
                this.address_1 = address_1;
        }

        public String getAddress_2() {
                return address_2;
        }

        public void setAddress_2(String address_2) {
                this.address_2 = address_2;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getZip() {
                return zip;
        }

        public void setZip(String zip) {
                this.zip = zip;
        }

        public Date getDate() { return date; }

        public void setDate(Date date) { this.date = date; }
}
