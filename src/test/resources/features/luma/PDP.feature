@regression
Feature: Luma Product Details Page - Category Navigation and Search
  As a customer
  I want to see the details for the product I am interested in
  So that I can decide whether it is the product I want

  Background:
    Given Luma Home Page

  @pdp
  Scenario Outline: Navigate Simple Product via Top Category
    When User Trigger Top Level Entry "<topcat>"
    And User Click Simple Product "<sproduct>"
    Then PDP for Simple Product "<sproduct>" is Displayed
    Examples:
      | topcat | sproduct |
      | What's New | Overnight Duffle |
      | Gear | Affirm Water Bottle |
      | Training | LifeLong Fitness IV |

  @pdp
  Scenario Outline: Navigate Simple Product via Sub Category
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    And User Click Simple Product "<sproduct>"
    Then PDP for Simple Product "<sproduct>" is Displayed
    Examples:
      | topcat | subcategory | sproduct |
      | Training | Video Download | Luma Yoga For Life |
      | Gear | Bags | Endeavor Daytrip Backpack |
      | Gear | Fitness Equipment | Sprite Foam Yoga Brick |
      | Gear | Watches | Bolo Sport Watch |

  @pdpconfig
  Scenario Outline: Navigate Configurable Product via Top Category
    When User Trigger Top Level Entry "<topcat>"
    And User Click Configurable Product "<cproduct>"
    Then PDP for Configurable Product "<cproduct>" is Displayed
    Examples:
      | topcat | cproduct |
      | Men | Geo Insulated Jogging Pant |
      | Women | Deirdre Relaxed-Fit Capri |

  @pdpconfig
  Scenario Outline: Navigate Configurable Product via Sub Category
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    And User Click Configurable Product "<cproduct>"
    Then PDP for Configurable Product "<cproduct>" is Displayed
    Examples:
      | topcat | subcategory | cproduct |
      | Women | Women Tops | Karissa V-Neck Tee |
      | Men | Men Bottoms | Hawkeye Yoga Short |
      | Women | Women Bottoms | Gwen Drawstring Bike Short |
      | Men | Men Tops | Cassius Sparring Tank |