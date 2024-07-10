Feature: Product Search

  Scenario: Search for T-shirts by color, size, gender and  sorted by price
  Given T-shirt data is loaded
  When the user searches for T-shirt with color "Purple", size "M", gender "M", and output preference "Price"
  Then the user should see a list of matching T-shirts sorted by Price

  Scenario: Search for T-shirts by color, size, and gender, sorted by rating
  Given T-shirt data is loaded
  When the user search for T-shirt with color "blue", size "S", gender "F", and output preference "Rating"
  Then the user should see a list of matching T-shirts sorted by "RATING"

  Scenario: Search for T-shirts by color, size, and gender, sorted by both price and rating
  Given T-shirt data is loaded
  When User search for T-shirts with color "yellow", size "L", gender "M", and output preference "BOTH"
  Then User should get a list of matching T-shirts sorted by both "PRICE" and "RATING"






