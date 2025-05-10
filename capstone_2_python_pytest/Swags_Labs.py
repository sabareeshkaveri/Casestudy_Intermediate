import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

class SwagLabsAutomation:
    def __init__(self, driver):
        self.driver = driver
        self.base_url = "https://www.saucedemo.com/"
    
    def open_url(self):
        self.driver.get(self.base_url)
        time.sleep(2)  # Slow down by 2 seconds
    
    def verify_swag_labs_present(self):
        swag_labs_text = self.driver.find_element(By.XPATH, "//div[@class='login_logo']").text
        assert swag_labs_text.lower() == "swag labs".lower(), f"Expected 'Swag Labs' but found {swag_labs_text}"
        print("SWAG LABS is present on the page.")
        time.sleep(1)  # Slow down by 1 second
    def handle_alert(self):
        try:
            time.sleep(1)  # Optional small delay to wait for alert to appear
            alert = self.driver.switch_to.alert
            print("Alert is present, accepting it...")
            alert.accept()  # Accept the alert
            time.sleep(1)  # Wait for any subsequent changes after accepting the alert
        except Exception as e:
            print(f"No alert found or error handling alert: {str(e)}")

    def login(self, username, password):
        self.driver.find_element(By.ID, "user-name").send_keys(username)
        self.driver.find_element(By.ID, "password").send_keys(password)
        self.driver.find_element(By.ID, "login-button").click()
        time.sleep(2)  # Slow down by 2 seconds
    
    def add_item_to_cart(self):
        item_button = self.driver.find_element(By.XPATH, "//button[contains(text(), 'Add to cart')]")
        item_button.click()
        time.sleep(1)  # Slow down by 1 second
    
    def verify_item_in_cart(self):
        cart_icon = self.driver.find_element(By.XPATH, "//a[@class='shopping_cart_link']")
        cart_icon.click()
        cart_items = self.driver.find_elements(By.XPATH, "//div[@class='cart_item']")
        assert len(cart_items) > 0, "No items found in the cart!"
        print("Item added to cart successfully.")
        time.sleep(2)  # Slow down by 2 seconds
    
    def logout(self):
        menu_button = self.driver.find_element(By.ID, "react-burger-menu-btn")
        menu_button.click()
        time.sleep(1)  # Slow down by 1 second
        logout_button = self.driver.find_element(By.ID, "logout_sidebar_link")
        logout_button.click()
        print("Logged out successfully.")
        time.sleep(1)  # Slow down by 1 second


@pytest.fixture
def setup():
    from selenium import webdriver
    from selenium.webdriver.chrome.service import Service
    from webdriver_manager.chrome import ChromeDriverManager

    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    driver.maximize_window()
    yield driver
    driver.quit()


def test_swag_labs_automation(setup):
    swag_labs = SwagLabsAutomation(setup)
    swag_labs.open_url()
    swag_labs.verify_swag_labs_present()
    swag_labs.login("standard_user", "secret_sauce")
    swag_labs.handle_alert()  # Handle alert if present
    time.sleep(1)  # Slow down by 1 second
    swag_labs.add_item_to_cart()
    swag_labs.verify_item_in_cart()
    swag_labs.logout()
