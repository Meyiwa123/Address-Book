# Address Book Application
The Address Book Application is a Spring Boot-based web application that allows users to manage their address books and 
buddy information. Users can create, update, retrieve, and delete address books and buddy information through a 
user-friendly API.

## Prerequisites
* Java Development Kit (JDK) 17 or higher

## Getting Started

### Installation
1. Clone the repository
2. Navigate to the project directory
3. Build the project using Maven:
    ```bash
    git clone https://github.com/Meyiwa123/address-book.git
    cd address-book-application
    mvn clean install
    ```

## Testing
The project includes unit tests to ensure the functionality of the endpoints.
You can run the tests using the following Maven command:
    ```
    mvn test
    ```

## Usage - API Endpoints
1. Address Book Endpoints
    * Create Address Book - URL: POST /api/v1/address-book/new
    * Get Address Book by ID - URL: GET /api/v1/address-book/{id}
    * Get All Address Books - URL: GET /api/v1/address-book
    * Update Address Book - URL: PUT /api/v1/address-book/{id}
    * Delete Address Book - URL: DELETE /api/v1/address-book/{id}

2. Buddy Info Endpoints
   * Create Buddy Info - URL: POST /api/v1/buddy-info/{addressBookId}
   * Get Buddy Info by ID - URL: GET /api/v1/buddy-info/{id}
   * Get All Buddy Infos -URL: GET /api/v1/buddy-info
   * Update Buddy Info -URL: PUT /api/v1/buddy-info/{id}
   * Delete Buddy Info -URL: DELETE /api/v1/buddy-info/{id}