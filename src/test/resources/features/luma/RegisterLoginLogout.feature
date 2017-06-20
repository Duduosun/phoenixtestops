@regression
Feature: Guest User to Registered User Login and Logout
  As a guest user
  I want to register on Luma
  So as to Login and Logout

  Background:
    Given Luma Home Page

  @createuser
    Scenario Outline: Guest User Sign Up to be Registered User
      When User Trigger Sign Up Action with "<firstName>","<lastName>","<email>","<password>" Details
      Then New User "<rUser>" is active
      Examples:
        | firstName | lastName | email | password | rUser |
        #| bdd1001 | Duduosun | bdd1001@duduosun.com | Salmon01 | bdd1001 Duduosun |
        #| bdd1002 | Duduosun | bdd1002@duduosun.com | Salmon02 | bdd1002 Duduosun |
        #| bdd1003 | Duduosun | bdd1003@duduosun.com | Salmon03 | bdd1003 Duduosun |
        #| bdd1004 | Duduosun | bdd1004@duduosun.com | Salmon04 | bdd1004 Duduosun |
        #| bdd1005 | Duduosun | bdd1005@duduosun.com | Salmon05 | bdd1005 Duduosun |
        #| bdd1006 | Duduosun | bdd1006@duduosun.com | salmon06 | bdd1006 Duduosun |
        #| bdd1007 | Duduosun | bdd1007@duduosun.com | salmon07 | bdd1007 Duduosun |
        | bdd8017 | Duduosun | bdd8017@duduosun.com | Salmon07 | bdd8017 Duduosun |

  @userlogin
  Scenario Outline: Registered User Login and Logout
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      And User "<rUser>" is active
    Examples:
      | rUser | rUsername | rPassword |
      | bdd1001 Duduosun | bdd1001@duduosun.com | Salmon01 |
      | bdd1002 Duduosun | bdd1002@duduosun.com | Salmon02 |
      | bdd1003 Duduosun | bdd1003@duduosun.com | Salmon03 |
      | bdd1004 Duduosun | bdd1004@duduosun.com | Salmon04 |
      | bdd1005 Duduosun | bdd1005@duduosun.com | Salmon05 |
      | bdd8017 Duduosun | bdd8017@duduosun.com | Salmon07 |