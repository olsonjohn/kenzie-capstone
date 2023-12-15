package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.Objects;

@DynamoDBTable(tableName = "Users")
public class UserRecord {
  private String userId;
  private String username;
  private String firstName;
  private String lastName;
  private String birthDate;
  private String address;
  private String phoneNum;
  private String email;
  private String dateJoined;

  @DynamoDBHashKey(attributeName = "userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @DynamoDBAttribute(attributeName = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @DynamoDBAttribute(attributeName = "firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @DynamoDBAttribute(attributeName = "lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @DynamoDBAttribute(attributeName = "birthDate")
  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @DynamoDBAttribute(attributeName = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @DynamoDBAttribute(attributeName = "phoneNum")
  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  @DynamoDBAttribute(attributeName = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @DynamoDBAttribute(attributeName = "dateJoined")
  public String getDateJoined() {
    return dateJoined;
  }

  public void setDateJoined(String dateJoined) {
    this.dateJoined = dateJoined;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserRecord that = (UserRecord) o;
    return Objects.equals(userId, that.userId)
        && Objects.equals(username, that.username)
        && Objects.equals(firstName, that.firstName)
        && Objects.equals(lastName, that.lastName)
        && Objects.equals(birthDate, that.birthDate)
        && Objects.equals(address, that.address)
        && Objects.equals(phoneNum, that.phoneNum)
        && Objects.equals(email, that.email)
        && Objects.equals(dateJoined, that.dateJoined);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        userId, username, firstName, lastName, birthDate, address, phoneNum, email, dateJoined);
  }
}
