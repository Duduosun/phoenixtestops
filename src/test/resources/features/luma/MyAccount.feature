@regression
  Feature: Registered User navigates My Account

    Background:
      Given Luma Home Page

    @createcheckusers
    Scenario Outline: Sign Up New Account
      When User Trigger Sign Up Action with "<firstName>","<lastName>","<email>","<password>" Details
      Then New User "<rUser>" is active
      Examples:
        | firstName | lastName | email | password | rUser |
        #| bdd1001 | Duduosun | bdd1001@duduosun.com | salmon01 | bdd1001 Duduosun |
        #| bdd1002 | Duduosun | bdd1002@duduosun.com | salmon02 | bdd1002 Duduosun |
        #| bdd1003 | Duduosun | bdd1003@duduosun.com | salmon03 | bdd1003 Duduosun |
        #| bdd1004 | Duduosun | bdd1004@duduosun.com | salmon04 | bdd1004 Duduosun |
        #| bdd1005 | Duduosun | bdd1005@duduosun.com | salmon05 | bdd1005 Duduosun |
        #| bdd1006 | Duduosun | bdd1006@duduosun.com | salmon06 | bdd1006 Duduosun |
        #| bdd1007 | Duduosun | bdd1007@duduosun.com | salmon07 | bdd1007 Duduosun |
        | check1001 | Duduosun | check1001@duduosun.com | Salmon01 | check1001 Duduosun |
        | check1002 | Duduosun | check1001@duduosun.com | Salmon02 | check1002 Duduosun |

    @account
    Scenario Outline: My Dashboard View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      And My Dashboard for Registered User "<rUser>" and "<rUsername>" is Displayed
      And User "<rUser>" is active

      Examples:
        | rUser | rUsername | rPassword |
        | BDD1001 Duduosun | bdd1001@duduosun.com | Salmon01 |
        #| Veronica Costello | roni_cost@example.com | roni_cost@example.com | #nublue

    @account
    Scenario Outline: My Account Information View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then Account Information for Registered User "<rUsername>" is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab |
        | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Account Information |

    @account
    Scenario Outline: My Address Book View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then Address Book for Registered User "<rUser>" is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab |
        | BDD1001 Duduosun | bdd1001@duduosun.com | Salmon01 | Address Book |

    @account
    Scenario Outline: My Downloadable Products View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then Downloadable Products "<vproduct>" is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab | vproduct |
        | BDD1001 Duduosun | bdd1001@duduosun.com | Salmon01 | My Downloadable Products | Luma Yoga For Life |

    @account
    Scenario Outline: My Orders View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then Orders for Registered User "<rUser>" is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab |
        | BDD1001 Duduosun | bdd1001@duduosun.com | Salmon01 | My Orders |

    @account
    Scenario Outline: My Newsletter Subscriptions View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then Newsletter Subscriptions is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab |
        | BDD1001 Duduosun | bdd1001@duduosun.com | Salmon01 | Newsletter Subscriptions |

    @account
    Scenario Outline: My Billing Agreement View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then Billing Agreements is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab |
        | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Billing Agreements |

    @account
    Scenario Outline: My My Product Reviews View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then My Product Reviews is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab |
        | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | My Product Reviews |

    @account
    Scenario Outline: My Wish List Subscriptions View
      When User Interact with Luma Website
      And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
      Then Luma Default for Registered "<rUser>" is available
      When User Trigger My Account "<accounttab>" Tab
      Then My Wish List "<wproduct>" is Displayed
      And Luma Module for Registered "<rUser>" remain available
      Examples:
        | rUser | rUsername | rPassword | accounttab | wproduct |
        | BDD1001 Duduosun | bdd1001@duduosun.com | Salmon01 | My Wish List | Meteor Workout Short |