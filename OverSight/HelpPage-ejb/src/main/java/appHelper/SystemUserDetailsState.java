/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appHelper;

import entity.SystemUserDetails;
import java.io.Serializable;

/**
 *
 * @author Forde
 */
public class SystemUserDetailsState implements Serializable {

    private Long id;
    private String givenName;
    private String familyName;
    private String age;
    private String contactNo;
    private String email;
    private String status;

    public SystemUserDetailsState(SystemUserDetails s) {
        this.setId(s.getId());
        this.setGivenName(s.getGivenName());
        this.setFamilyName(s.getFamilyName());
        this.setAge(s.getAge());
        this.setContactNo(s.getContactNo());
        this.setEmail(s.getEmail());
        this.setStatus(s.getStatus());
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
