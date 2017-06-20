@regression
Feature: User Wish List Module

  Background:
    Given Luma Home Page

  @wishlist
  Scenario: Guest User Trigger Wish List
    When User Trigger Wish List Entry Point CTA
    Then Registered User Entry Point is Displayed

  @wishlist
  Scenario Outline: Populate Wish List from Base Page
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Top Level Entry "<topCat>"
    And User Add One of Listed Products "<wProduct>" to Wish List
    Then My Wish List "<wProduct>" is Displayed
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topCat | wProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | What's New | Rival Field Messenger |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Women | Breathe-Easy Tank |

  @wishlist
  Scenario Outline: Populate Wish List from PLP
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Top Level "<topCat>" then Sub Category Level "<subCat>"
    And User Add One of Listed Products "<wProduct>" to Wish List
    Then My Wish List "<wProduct>" is Displayed
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topCat | subCat | wProduct |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Men | Men Tops | Balboa Persistence Tee |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Gear | Bags | Voyage Yoga Bag |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Men | Men Tops | Zoltan Gym Tee |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Gear | Watches | Cruise Dual Analog Watch |

  @wishlist
  Scenario Outline: Populate Wish List from PDP
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Trigger Top Level Entry "<topcat>"
    And User Click Configurable Product "<wProduct>"
    And User Add PDP Product "<wProduct>" to Wish List
    Then My Wish List "<wProduct>" is Displayed
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topcat | wProduct |
      | BDD1004 Duduosun | bdd1004@duduosun.com | Salmon04 | Women | Selene Yoga Hoodie |
      | BDD1004 Duduosun | bdd1004@duduosun.com | Salmon04 | Men | Hero Hoodie |

  @wishlist
  Scenario Outline: Remove Wish List Product via My Account
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    When User Remove Product "<wProduct>" from Sidebar Wish List
    Then Product "<wProduct>" is not Visible in My Wish List
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | wProduct |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Rival Field Messenger |
      | BDD1002 Duduosun | bdd1002@duduosun.com | Salmon02 | Breathe-Easy Tank |

  @wishlist
  Scenario Outline: Remove Wish List Product via My Wish List
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    And User Trigger My Account "<accounttab>" Tab
    And My Wish List "<wProduct>" is Displayed
    When User Remove Product "<wProduct>" from My Wish List Dasboard
    Then Product "<wProduct>" is not Visible in My Wish List
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | accounttab | wProduct |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | My Wish List | Balboa Persistence Tee |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | My Wish List | Voyage Yoga Bag |

  @wishlist
  Scenario Outline: Remove Wish List Product via Base Page
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    And User Trigger Top Level Entry "<topcat>"
    When User Remove Product "<wProduct>" from Sidebar Wish List
    Then Product "<wProduct>" is not Visible in My Wish List
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topcat | wProduct |
      | BDD1004 Duduosun | bdd1004@duduosun.com | Salmon04 | Women | Selene Yoga Hoodie |
      | BDD1004 Duduosun | bdd1004@duduosun.com | Salmon04 | Men | Hero Hoodie |

  @wishlist
  Scenario Outline: Remove Wish List Product via PLP
    And Trigger Registered "<rUser>" Action with "<rUsername>" and "<rPassword>"
    And User Trigger Top Level "<topCat>" then Sub Category Level "<subCat>"
    When User Remove Product "<wProduct>" from Sidebar Wish List
    Then Product "<wProduct>" is not Visible in My Wish List
    And Luma Module for Registered "<rUser>" remain available
    Examples:
      | rUser | rUsername | rPassword | topCat | subCat | wProduct |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Men | Men Top | Zoltan Gym Tee |
      | BDD1003 Duduosun | bdd1003@duduosun.com | Salmon03 | Gear | Watches | Cruise Dual Analog Watch |