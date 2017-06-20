@smoketestops
Feature: Guest User and Registered User Entry Point
  As a User
  I want to browse Magento 2 Demo Website

  Background:
    Given Luma Home Page

  @users
  Scenario: Home Page Browse Header
    When User Explores Home Page
    Then Header Elements are Interactive

  @users
  Scenario: Home Page Browse Footer
    When User Explores Home Page
    Then Footer Elements are Interactive