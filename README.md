# University Management System

This project is a simple Java application for managing university-related information, including students, courses, professors, and disciplines. The system allows for basic CRUD operations (Create, Read, Update, Delete) on these entities and provides a graphical user interface for easy interaction.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Overview

The University Management System consists of several components, including:

- **alunosDAO**: Handles data access operations related to students.
- **cursosDAO**: Manages data access for courses.
- **disciplinasDAO**: Handles data access operations related to disciplines.
- **professoresDAO**: Manages data access for professors.
- **home**: The main application window that provides a graphical user interface.

## Features

- **CRUD Operations**: Perform basic Create, Read, Update, and Delete operations on students, courses, disciplines, and professors.
- **Data Relationships**: View relationships between courses, professors, and disciplines.
- **Graphical Interface**: Use a simple and intuitive graphical interface for better user interaction.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- MySQL Database Server.

### Installation

1. Clone the repository:

```bash
git clone https://github.com/WillGolden80742/TrabalhoALPOO.git
```

2. Set up the MySQL database:
   - Create a new database and execute the SQL script provided in the `database_scripts` directory to create the necessary tables.

3. Open the project in your preferred Java IDE.

4. Configure the database connection in the `ConnectionFactory` class.

5. Run the `home` class to start the application.

## Usage

- Launch the application and use the menu to navigate through different functionalities.
- Perform CRUD operations on students, courses, professors, and disciplines.
- View relationships between entities.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- FlatLaf Library: [FormDev](https://github.com/FlatLaf/FlatLaf)
- MySQL Database: [MySQL](https://www.mysql.com/)
- Icons: [FontAwesome](https://fontawesome.com/)
```

Make sure to replace placeholders like `your-username` and update the content accordingly. Feel free to add or modify sections based on your project's specific needs.
