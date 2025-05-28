# Avocado Dashboard

This Challenge is a angular application that displays avocado prices using a CSV file. The application includes a table and a chart to visualize the data, with filters for `Region` and `Type`. The project is built using angular, primeNG, and Recharts.

## Steps to Create the Project

### 1. Set up the project environment
Initialize a new angular project. Install the required dependencies such as angular, primeNG for UI components, and Recharts for data visualization.

### 2. Create the initial `avocado.csv` file
Prepare a CSV file containing avocado price data. This file should include columns like date, region, type, and price, which will be used throughout the application.

### 3. Create a component to load and display data from the CSV file
Develop a angular component that reads the CSV file, parses its contents, and displays the data in a table format. You can use any libraries you like  to handle CSV parsing.

### 4. Add filters to the table 
Implement dropdown or select controls to filter the table data by `Region` and `Type`. Update the displayed data based on the selected filters.

### 5. Create a chart with the data
Build a chart component using Recharts to visualize avocado prices over time or by region/type. Ensure the chart updates according to the filtered data.

### 6. Integrate the table and the chart
Synchronize the table and chart so that both reflect the same filtered dataset, providing a cohesive user experience.

### 7. Improve the design
Enhance the application's appearance using primeNG components and styles. Focus on layout, responsiveness, and usability for a polished final product.