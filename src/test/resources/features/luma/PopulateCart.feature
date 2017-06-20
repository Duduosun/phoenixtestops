@regression
  Feature: Populate Cart

    Background:
      Given Luma Home Page

    @addtocart
    Scenario Outline: Populate Cart via PLP - Simple Product
      When User Trigger Top Level "<topcat>" then Sub Category Level "<subcat>"
      And User Add One of Listed Products "<aProduct>" to Cart
      Then Product "<aProduct>" is added to Cart
      And Luma Recovery Scenario
      Examples:
        | topcat | subcat | aProduct |
        | Gear | Fitness Equipment | Dual Handle Cardio Ball |

    @addtocart
    Scenario Outline: Populate Cart via PDP - Simple Product
      When User Trigger Top Level Entry "<topcat>"
      And User Click Simple Product "<sProduct>"
      And User Add PDP Product "<sProduct>" to Cart
      Then Product "<sProduct>" is added to Cart
      And Luma Recovery Scenario
      Examples:
        | topcat | sProduct |
        | Training | Solo Power Circuit |

    @addtocart
    Scenario Outline: Populate Cart via Base Page - Simple Product
      When User Trigger Top Level Entry "<topcat>"
      And User Add One of Listed Products "<aProduct>" to Cart
      Then Product "<aProduct>" is added to Cart
      And Luma Recovery Scenario
      Examples:
        | topcat | aProduct |
        | What's New | Go-Get'r Pushup Grips |

    @addtocart
    Scenario Outline: Populate Cart via PDP - Configurable Product
      When User Trigger Top Level "<topcat>" then Sub Category Level "<subcat>"
      And User Click Configurable Product "<cProduct>"
      And User Select Random Swatch Options
      And User Add PDP Product "<cProduct>" to Cart
      Then Product "<cProduct>" is added to Cart
      And Luma Recovery Scenario
      Examples:
        | topcat | subcat | cProduct |
        | Women | Women Tops | Tiffany Fitness Tee |

    @addtocart
    Scenario Outline: Populate Cart via Search Result - Simple Product
      When User Search Luma with String "<search>"
      And User Click Simple Product "<sProduct>"
      And User Add PDP Product "<sProduct>" to Cart
      Then Product "<sProduct>" is added to Cart
      And Luma Recovery Scenario
      Examples:
        | search | sProduct |
        | bottle | Affirm Water Bottle |

    @addtocart
    Scenario Outline: Populate Cart via Search Result - Configurable Product
      When User Search Luma with String "<search>"
      And User Click Configurable Product "<cProduct>"
      And User Select Random Swatch Options
      And User Add PDP Product "<cProduct>" to Cart
      Then Product "<cProduct>" is added to Cart
      And Luma Recovery Scenario
      Examples:
        | search | cProduct |
        | jog | Geo Insulated Jogging Pant |