import time

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

# Define a fixture to initialize the browser
@pytest.fixture
def setup():
    driver = webdriver.Chrome()  # Assuming you're using Chrome. You can change this to another browser if needed.
    yield driver
    driver.quit()

# Define a generic function to log in
def login(driver, username, password):
    driver.get("https://www.saucedemo.com/")
    driver.find_element(By.ID, "user-name").send_keys(username)
    driver.find_element(By.ID, "password").send_keys(password)
    driver.find_element(By.ID, "login-button").click()

# Define a generic function to verify the presence of an element
def add_to_cart(driver):


    driver.find_element(By.XPATH,f"//button[@id='add-to-cart-sauce-labs-backpack']").click()
    driver.find_element(By.XPATH, f"//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]").click()





def added_item_present(driver):
    cart_item=driver.find_element(By.XPATH ,f"//div[text()='Sauce Labs Backpack']")
    assert cart_item is not None, "Element is not present on the page."

def menu(driver):
    driver.find_element(By.XPATH, f"//button[@id='react-burger-menu-btn']").click()
def logout(driver):
    driver.find_element(By.XPATH,f"//a[@id='logout_sidebar_link']").click()


# Define the test function for the case study
def test_case_study(setup):
    username = "standard_user"
    password = "secret_sauce"
    login(setup,username,password)
    add_to_cart(setup)
    added_item_present(setup)
    print("element is present")
    menu(setup)
    time.sleep(2)
    logout(setup)
    time.sleep(2)







