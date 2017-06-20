@regression
Feature: Registered User Compare Products

  Background:
    Given Luma Home Page

  @CompareRegistered
  Scenario Outline: Registered User Compare Product via Base Page
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Top Level Entry "<topcat>"
    And User Compare One of Listed Products "<cProduct>"
    Then Listed Product "<cProduct>" is Added to Compare Products
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topcat | cProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Men | Argus All-Weather Tank |

  @CompareRegistered
  Scenario Outline: Registered User Compare Product via PLP
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Top Level "<topCat>" then Sub Category Level "<subCat>"
    And User Compare One of Listed Products "<cProduct>"
    Then Listed Product "<cProduct>" is Added to Compare Products
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topCat | subCat | cProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Gear | Watches | Aim Analog Watch |

  @CompareRegistered
  Scenario Outline: Registered User Compare Product via PDP
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Top Level Entry "<topcat>"
    And User Click Configurable Product "<cProduct>"
    And User Compare PDP Product "<cProduct>"
    Then PDP Product "<cProduct>" is Added to Compare Products
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topcat | cProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Gear | Affirm Water Bottle |

  @CompareRegistered
  Scenario Outline: Registered User Compare N Products
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Top Level Entry "<topCat>"
    And User Compare One of Listed Products "<aProduct>"
    And User Compare One of Listed Products "<bProduct>"
    And User Compare One of Listed Products "<cProduct>"
    And User Compare One of Listed Products "<dProduct>"
    Then Products "<aProduct>" "<bProduct>" "<cProduct>" "<dProduct>" are Displayed on Compare Product Module
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topCat | aProduct | bProduct | cProduct | dProduct |
      | BDD1004 Duduosun | bdd1004@duduosun.com | Salmon04 | Women | Breathe-Easy Tank | Selene Yoga Hoodie  | Deirdre Relaxed-Fit Capri | Radiant Tee |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Men | Hero Hoodie | Argus All-Weather Tank | Geo Insulated Jogging Pant | Meteor Workout Short |

  @CompareRegistered
  Scenario Outline: Remove Compared Product via My Account
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Remove Compared Product "<cProduct>" via Sidebar
    Then Product "<cProduct>" is not Visible in Compare Products
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | cProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Argus All-Weather Tank |

  @CompareRegistered
  Scenario Outline: Remove Compared Product via Base Page
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    And User Trigger Top Level Entry "<topcat>"
    When User Remove Compared Product "<cProduct>" via Sidebar
    Then Product "<cProduct>" is not Visible in Compare Products
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topcat | cProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Gear | Affirm Water Bottle |

  @CompareRegistered
  Scenario Outline: Remove Compared Product via PLP
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    And User Trigger Top Level "<topCat>" then Sub Category Level "<subCat>"
    When User Remove Compared Product "<cProduct>" via Sidebar
    Then Product "<cProduct>" is not Visible in Compare Products
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topCat | subCat | cProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Gear | Watches | Aim Analog Watch |

  @CompareRegistered
  Scenario Outline: Remove Compared Product via Compare Page
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Compare Products CTA
    Then Compare Product Module is Displayed
    When User Remove Compared Products via Compare Products Page
    Then All Compared Products are not Visible in Compare Products
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword |
      | BDD1004 Duduosun | bdd1004@duduosun.com | Salmon04 |

  @CompareRegistered
  Scenario Outline: Remove all Compared Products with One Click
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    And User Trigger Top Level Entry "<topCat>"
    When User Remove all Compared Product
    Then Compare Product Module is Cleared
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topCat |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Training |