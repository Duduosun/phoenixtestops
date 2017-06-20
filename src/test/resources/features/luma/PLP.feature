@regression
Feature: Luma Product List Page
  As a customer
  I want to choose whether I want to see products presented as a list or a grid view
  So that I can see it in a way that works for me

  Background:
    Given Luma Home Page

  @subcat
  Scenario Outline: Navigate Simple Products PLP Default
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    Then Simple Products "<sproducts>" are Displayed in Grid View
    Examples:
      | topcat | subcategory | sproducts |
      | Gear | Bags | Voyage Yoga Bag |
      | Training | Video Download | Solo Power Circuit |

  @subcat
  Scenario Outline: Navigate Configurable Products PLP Default
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    Then Configurable Products "<cproducts>" are Displayed in Grid View
    Examples:
      | topcat | subcategory | cproducts |
      | Women | Women Tops | Diva Gym Tee |
      | Men | Men Bottoms | Rapha Sports Short |

  @subcat
  Scenario Outline: Navigate Simple Products PLP List View
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    And User Click Switch View CTA
    Then Simple Products "<sproducts>" are Displayed in List View
    Examples:
      | topcat | subcategory | sproducts |
      | Gear | Fitness Equipment | Sprite Foam Yoga Brick |
      | Gear | Watches | Cruise Dual Analog Watch |

  @subcat
  Scenario Outline: Navigate Configurable Products PLP List View
    When User Trigger Top Level "<topcat>" then Sub Category Level "<subcategory>"
    And User Click Switch View CTA
    Then Configurable Products "<cproducts>" are Displayed in List View
    Examples:
      | topcat | subcategory | cproducts |
      | Women | Women Bottoms | Echo Fit Compression Short |
      | Men | Men Tops | Aero Daily Fitness Tee |
