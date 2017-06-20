@regression
Feature: Browse Top Level Category
  As a User
  I want to browse and navigate all Top Level Categories
  So as to view all Page Modules

  Background:
    Given Luma Home Page

  @topcat
  Scenario Outline: What's New, Women and Men
    When User Trigger Top Level Entry "<topcat>"
    Then Page "<topcat>" Header and Footer Elements are Interactive
    And Complete LHS and Promo Module is Visible
    And Product List is Displayed with "<espotproduct>"
    Examples:
      | topcat | espotproduct |
      | What's New | Wayfarer Messenger Bag |
      | Women | Selene Yoga Hoodie |
      | Men | Geo Insulated Jogging Pant |

  @topcat
  Scenario Outline: Gear with Empty LHS
    When User Trigger Top Level Entry "<topcat>"
    Then Page "<topcat>" Header and Footer Elements are Interactive
    And Empty LHS and Promo Module is Visible
    And Product List is Displayed with "<espotproduct>"
    Examples:
      | topcat | espotproduct |
      | Gear | Sprite Yoga Companion Kit |

  @topcat
  Scenario Outline: Training with Promo Only
    When User Trigger Top Level Entry "<topcat>"
    Then Page "<topcat>" Header and Footer Elements are Interactive
    And Single LHS and Promo Module is Visible
    And Product List is Displayed with "<espotproduct>"
    Examples:
      | topcat | espotproduct |
      | Training | Luma Yoga For Life |

  @topcat
  Scenario Outline: Sale without Products
    When User Trigger Top Level Entry "<topcat>"
    Then Page "<topcat>" Header and Footer Elements are Interactive
    And Complete LHS and Promo Module is Visible
    Examples:
      | topcat |
      | Sale |