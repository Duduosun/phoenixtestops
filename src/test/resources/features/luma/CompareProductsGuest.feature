@regression
Feature: Guest User Compare Products

  Background:
    Given Luma Home Page

  @CompareGuest @btdsmoke
  Scenario Outline: Guest User Populate Compare Product via Base Page
    When User Trigger Top Level Entry "<topCat>"
    And User Compare One of Listed Products "<cProduct>"
    Then Listed Product "<cProduct>" is Added to Compare Products
    And Luma Module for Guest remain available
    Examples:
      | topCat | cProduct |
      | What's New | Go-Get'r Pushup Grips |

  @CompareGuest
  Scenario Outline: Guest User Populate Compare Product from PLP
    When User Trigger Top Level "<topCat>" then Sub Category Level "<subCat>"
    And User Compare One of Listed Products "<cProduct>"
    Then Listed Product "<cProduct>" is Added to Compare Products
    And Luma Module for Guest remain available
    Examples:
      | topCat | subCat | cProduct |
      | Gear | Fitness Equipment | Sprite Foam Yoga Brick |

  @CompareGuest
  Scenario Outline: Guest User Populate Compare Product from PDP
    When User Trigger Top Level Entry "<topcat>"
    And User Click Configurable Product "<cProduct>"
    And User Compare PDP Product "<cProduct>"
    Then PDP Product "<cProduct>" is Added to Compare Products
    And Luma Module for Guest remain available
    Examples:
      | topcat | cProduct |
      | Women | Deirdre Relaxed-Fit Capri |

  @CompareGuest
  Scenario Outline: Guest User Compare N Products
    When User Trigger Top Level Entry "<topCat>"
    And User Compare One of Listed Products "<aProduct>"
    And User Compare One of Listed Products "<bProduct>"
    And User Compare One of Listed Products "<cProduct>"
    And User Compare One of Listed Products "<dProduct>"
    Then Products "<aProduct>" "<bProduct>" "<cProduct>" "<dProduct>" are Displayed on Compare Product Module
    And Luma Module for Guest remain available
    Examples:
      | topCat | aProduct | bProduct | cProduct | dProduct |
      | Men | Hero Hoodie | Argus All-Weather Tank | Geo Insulated Jogging Pant | Meteor Workout Short |