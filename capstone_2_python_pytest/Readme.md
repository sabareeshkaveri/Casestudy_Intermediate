Swag Labs Automation Test Project
This project contains automation tests for the Swag Labs website using Selenium WebDriver and the pytest framework. The tests include verifying the page, performing a login, adding items to the cart, and logging out.

Table of Contents
Project Overview

Technologies Used

Setup Instructions

Running Tests

Contributing

License

Project Overview
The Swag Labs Automation project aims to test key features of the Swag Labs website using automated Selenium tests. The tests are written in Python and executed using the pytest framework, with the configuration stored in setup.cfg.

Features:
Verify "SWAG LABS" logo on the homepage.

Perform login with valid credentials.

Add items to the shopping cart.

Verify the shopping cart has items.

Logout from the website.

Technologies Used
Selenium WebDriver: For browser automation.

pytest: For running the tests and generating reports.

ChromeDriver: For interacting with the Chrome browser.

Python: The programming language used to write the tests.

Setup Instructions
1. Clone the repository
Start by cloning the project to your local machine:

bash
Copy
github.com

cd swag-labs-automation
2. Set up a Python Virtual Environment
Create and activate a virtual environment to isolate project dependencies:

On macOS/Linux:
bash
Copy
python3 -m venv .venv
source .venv/bin/activate
On Windows:
bash
Copy
python -m venv .venv
.\.venv\Scripts\activate
3. Install Dependencies
Install the required Python packages by running:

bash
Copy
pip install -r requirements.txt
This will install Selenium, pytest, and other required packages.

run the cmd
pytest /Users/kaverisabareesh/Documents/Python_Scripts/Projects/Capsule_Project_1/Swags_Labs.py
4. Install WebDriver
Make sure to have ChromeDriver installed on your machine. You can download it from the following link:
ChromeDriver Downloads

Ensure that the chromedriver binary is in your system's PATH, or you can provide the path to chromedriver in the Swags_Labs.py script.