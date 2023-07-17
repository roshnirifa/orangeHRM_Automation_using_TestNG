# orangeHRM_Automation_using_TestNG
A TestNG automation project for the HR management system - https://opensource-demo.orangehrmlive.com/

## Project Summery
This project aims to automate the testing of the HR management system using TestNG framework. It performs various actions such as creating employees, searching for employees, updating employee information, and more.


## Technology Used
- Java
- Intellij idea
- Allure

## Pre requidtes
- JDK 11
- TestNG framework
- Selenium WebDriver
- Browser driver (e.g., ChromeDriver) compatible with your browser version


## Scenario
1.Login as a admin to https://opensource-demo.orangehrmlive.com/

2. Go to PIM menu and create a new employee. Save the employee firstname, lastname, employeeid, username and password into JSONArray file. Generate random password which meets following criteria:
For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers. Assert if employee is created successfully.

3. Now go to the dashboard again and search by the employee id to check if the employee is found

4. Now go to the Directory menu and search by employee name and check if the employee is found

5. Logout the session.

6. Now login with the newly created employee creds

7. Assert your full name is showing besides the profile icon.

8. Go to my info

9. Scroll down and select Gender and Blood Type as O+ and save it. Then logout the user.

10. Create a smoke suite configuration which will run only following features (positive cases only):

- Login to admin
- search by the employee id if found
- logout admin and login to the employee id you created last
- Update the blood Group as AB-
- Logout the user


## How to run
- ``git clone``


## Allure Report
![screencapture-192-168-0-108-52218-index-html-2023-07-17-10_16_20](https://github.com/roshnirifa/orangeHRM_Automation_using_TestNG/assets/74822231/82d2e7ef-1cf6-476c-b58c-f5e34e8cd703)
![screencapture-192-168-0-108-52218-index-html-2023-07-17-10_16_48](https://github.com/roshnirifa/orangeHRM_Automation_using_TestNG/assets/74822231/95ed6cf1-0574-479a-936f-d4fe61813ac6)
![screencapture-192-168-0-108-52218-index-html-2023-07-17-10_17_29](https://github.com/roshnirifa/orangeHRM_Automation_using_TestNG/assets/74822231/3e594c7e-4e09-4c49-ad2b-f2eff137c2ad)
![screencapture-file-G-Road-to-SDET-Assignment-testNg-orangeHrm-build-reports-tests-test-index-html-2023-07-17-10_17_58](https://github.com/roshnirifa/orangeHRM_Automation_using_TestNG/assets/74822231/3d3fe1e4-79de-4ac8-83ab-3767c7118cee)

## Test Case 
https://docs.google.com/spreadsheets/d/1fipz6Wcw9Xt7BRtUif9JIXTpOUNcG07k8VzeGRNgMQg/edit?usp=sharing


##  video output 
https://drive.google.com/file/d/17AGP3VltVOpRjdMbvghWZpHgm5ycmShR/view?usp=sharing
