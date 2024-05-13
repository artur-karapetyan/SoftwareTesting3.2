## Automated Tests Documentation

This repository contains automated tests for various functionalities for Zoomerang website. Below is a summary of the functionalities covered and the corresponding test cases.

### Test Cases

#### Sign Up - Functionality

1. **All Fields Verification**:
    - Verify that all required fields are validated properly during sign-up.
    - Test cases include:
        - Sign up with an invalid email.
        - Sign up with an invalid confirm password.

#### Search AI Gallery - (Discover/AI Gallery)

1. **Test Search Input**:
    - Verify the functionality of the search input in the AI Gallery.
    - Test cases include:
        - Entering text into the search input and verifying search results.

2. **Test Filter Search Results Functionality**:
    - Verify the functionality of filtering search results by style and AI tool.
    - Test cases include:
        - Filter search results by style.
        - Filter search results by AI tool.

#### Contact Us Form Functionality

1. **Validate all fields**:
    - Verify that the contact form can be submitted successfully with valid input fields without clicking the submit button.
    - Test cases include:
        - Filling out the contact form with invalid input fields and verifying error message.

### Test Structure

- Each test case is implemented using Selenium WebDriver and TestNG.
- Page Object Model (POM) design pattern is followed for better code organization and maintainability.
- Test data is managed using test data files and fixtures.
- Assertions are used to validate the expected behavior of the application.
- Screenshots are captured for failed test cases to aid in debugging.

### Setup Instructions

1. Clone the repository to your local machine.
2. Install the required dependencies specified in the `pom.xml` file.
3. Run the tests using your preferred test runner or IDE.

### Notes

- Ensure that the application is running and accessible before executing the tests.
- Update the test data files with valid test data as required.

### Creator

- Artur Karapetyan
