# LibraNet - A Spring Boot Library Management Web App 📚

Welcome to LibraNet! This is a simple, web-based library management system built with Java and the Spring Boot framework. It allows users to view a catalog of library items (books, audiobooks, e-magazines), borrow them, and return them. The system features a clean user interface and an automated fine calculation system based on due dates.

This project is an excellent example of a modern Model-View-Controller (MVC) web application.

---

## ✨ Features

- **View Catalog:** Browse a complete list of all library items.
- **Borrow Items:** Borrow any available item with a single click.
- **Return Items:** Return a borrowed item to make it available again.
- **Automated Due Dates:** When an item is borrowed, a due date is automatically set for a 14-day loan period.
- **Automatic Fine Calculation:** If an item is returned after its due date, a fine is automatically calculated and recorded.

---

## 🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Make sure you have the following software installed on your system:
- **Java Development Kit (JDK)** - Version 17 or newer.
- **Apache Maven** - For building the project and managing dependencies.
- **Git** - For cloning the repository.

### Installation & Running

1.  **Clone the repository** to your local machine:
    ```sh
    git clone [https://github.com/Sai-premjeet-Das/LibraNet.git](https://github.com/YOUR_USERNAME/LibraNet.git)
    ```

2.  **Navigate to the project directory**:
    ```sh
    cd libranet
    ```

3.  **Build the project using Maven**:
    This command will download all the necessary dependencies and compile the source code.
    ```sh
    mvn clean install
    ```

4.  **Run the application**:
    Once the build is successful, you can start the application with this command.
    ```sh
    mvn spring-boot:run
    ```
    The application will start, and you will see the Spring Boot banner in your terminal.

5.  **Access the application**:
    Open your favorite web browser and navigate to the following URL:
    [**http://localhost:8080**](http://localhost:8080)

You should now see the LibraNet web application running!
