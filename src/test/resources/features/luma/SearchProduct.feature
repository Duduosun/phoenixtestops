@regression
Feature: Product Search
  As a customer
  I want to choose whether I want to see product search result presented as a list or a grid view
  So that I can see it in a way that works for me

  Background:
    Given Luma Home Page

  @search
  Scenario Outline: Search Simple Product Result Default PLP
    When User Search Luma with String "<search>"
    Then Search Results for "<sproducts>" are Displayed in Grid View
    Examples:
      | search | sproducts |
      | Backpack | Crown Summit Backpack |
      | video | Advanced Pilates & Yoga (Strength) |

  @search
  Scenario Outline: Search Configurable Product Result PLP List View
    When User Search Luma with String "<search>"
    And User Click Switch View CTA
    Then Search Results for "<cproducts>" are Displayed in List View
    Examples:
      | search | cproducts |
      | Tees on sale | Deion Long-Sleeve EverCool™ Tee |
      | New Yoga | Zeppelin Yoga Pant |

  @search
    Scenario Outline: Search Product with Empty Result
    When User Search Luma with String "<search>"
    Then Empty Search Result "<message>" is Displayed
    Examples:
      | search | message |
      | children | Your search returned no results |

  @search
  Scenario Outline: Search and Navigate to Simple Product
    When User Search Luma with String "<search>"
    And User Click Simple Product "<sproduct>"
    Then PDP for Simple Product "<sproduct>" is Displayed
    Examples:
      | search | sproduct |
      | bottle | Affirm Water Bottle |

  @search
  Scenario Outline: Search and Navigate to Configurable Product
    When User Search Luma with String "<search>"
    And User Click Configurable Product "<cproduct>"
    Then PDP for Configurable Product "<cproduct>" is Displayed
    Examples:
      | search | cproduct |
      | jog | Geo Insulated Jogging Pant |