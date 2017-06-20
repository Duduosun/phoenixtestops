@regression
  Feature: Mini Cart

    Background:
      Given Luma Home Page

    @minicart
    Scenario: Ohpen and Close Mini Cart
      When User Trigger Mini Cart
      Then Mini Cart remain Open
      When User Close Mini Cart
      Then Mini Cart is Closed

    @minicart
    Scenario Outline: Populate and Verify Non Empty Cart
      And User Trigger Top Level Entry "<topcat>"
      And User Add One of Listed Products "<aProduct>" to Cart
      When User Trigger Mini Cart
      Then Product "<aProduct>" is Visible in Mini Cart
      Examples:
        | topcat | aProduct |
        | What's New | Wayfarer Messenger Bag |
        | Gear | Fusion Backpack |

    @minicart
    Scenario Outline: Remove and Verify Empty Cart
      And User Trigger Top Level Entry "<topcat>"
      And User Add One of Listed Products "<aProduct>" to Cart
      When User Trigger Mini Cart
      And Remove Product "<aProduct>" in Mini Cart
      Then Mini Cart is Empty
      Examples:
        | topcat | aProduct |
        | What's New | Rival Field Messenger |
        | Gear | Affirm Water Bottle |

    @minicart
    Scenario Outline: Update Mini Cart Quantity
      And User Trigger Top Level "<topCat>" then Sub Category Level "<subCat>"
      And User Click Configurable Product "<cProduct>"
      And User Select Random Swatch Options
      And User Add PDP Product "<cProduct>" to Cart
      When User Trigger Mini Cart
      And Update Product Quantity with "<qty>"
      Then Product "<cProduct>" Quantity is Updated to "<qty>"
      Examples:
        | topCat | subCat | cProduct | qty |
        | Men | Men Bottoms | Meteor Workout Short | 3 |

    @minicart
    Scenario Outline: Edit Product Quantity via Mini Cart
      And User Trigger Top Level Entry "<topcat>"
      And User Add One of Listed Products "<aProduct>" to Cart
      When User Trigger Mini Cart
      And Edit Product with Quantity "<qty>"
      Then Product "<aProduct>" Quantity is Updated to "<qty>"
      Examples:
        | topcat | aProduct | qty |
        | Gear | Fusion Backpack | 7 |

    @minicart
    Scenario Outline: Edit Configurable Product Swatch Options via Mini Cart
      And User Trigger Top Level "<topCat>" then Sub Category Level "<subCat>"
      And User Click Configurable Product "<cProduct>"
      And User Select Random Swatch Options
      And User Add PDP Product "<cProduct>" to Cart
      When User Trigger Mini Cart
      And Edit Product with Swatch "<color>"
      Then Product "<cProduct>" Swatch is Updated to "<color>"
      Examples:
        | topCat | subCat | cProduct | color |
        | Women | Women Tops | Gwyn Endurance Tee | Yellow |