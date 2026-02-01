<h2>Test Automation Project for Electronics Store <a target="_blank" href="https://www.rbt.ru"> RBT.ru</a></h2>

## Description
RBT is a retail and wholesale electronics and home appliances store that includes a chain of retail shops and an online store.. <br/>

**Project features**:
- JUnit 5 is used in the project
- Allure
- Usage `Owner`
- Usage `Lombok`
- Allure report
- Appium
 -Selenide

## Implemented Checks
### Web UI
- [x] Select city from the main page
- [x] Negative test: city is not displayed for invalid input
- [x] Display correct content for the selected product category
- [x] Send verification code successfully for login
- [x] Negative test: do not send login code for invalid phone number
- [x] Search product by valid name
- [x] Negative test: do not display product for invalid search query
- [x] Add product to cart from product page

### API
- [x] Add product to cart
- [x] Negative test: add product to cart with invalid itemId
- [x] Remove existing product from cart
- [x] Negative test: remove product from cart with invalid itemId
- [x] Search products by query
- [x] Add product to favorites
- [x] Negative test: add non-existing product to favorites
- [x] Remove product from favorites
- [x] Negative test: remove non-existing product from favorites

### Mobile
- [x] Selected city is displayed on the main screen
- [x] Catalog content list contains all expected categories
- [x] App version is displayed correctly
- [x] Add product to cart from the main screen
- [x] Verify that product count is greater than the expected minimum value
