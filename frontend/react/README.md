# Avocado Dashboard

This project is an interactive dashboard that displays fictional data about avocado prices.

## Prompts Used

### 1. Set up the project environment
Prompt:
```
Create a React project inside the frontend/react folder from scratch using Vite. Set up the initial environment to work with functional components and React Hooks. Make sure to include Material-UI for styling.
```

Install all dependendencies before running the project:
```bash
npm install
```

Test the project:
```bash
npm run dev
```

### 2. Create the initial `avocado.csv` file
Prompt:
```
Create a file named `avocado.csv` containing fictional data about avocado prices. Include columns such as `Date`, `AveragePrice`, `TotalVolume`, `Region`, and `Type`. Fill the file with at least 10 rows of fictional data.
```

### 3. Create a component to load and display data
Prompt:
```
Create a component named `AvocadoTable` that loads data from `avocado.csv` and displays it in a table. Use React and Material-UI for the design. Make sure to manage the state for the loaded data.
```

### 4. Add filters to the table
Prompt:
```
Modify the `AvocadoTable` component to include filters by `Region` and `Type`. Use Material-UI for the filters and ensure they dynamically update the data shown in the table.
```

### 5. Create a chart with the data
Prompt:
```
Create a component named `AvocadoChart` that displays a line chart with the average price (`AveragePrice`) data over time (`Date`). Use the Recharts library to implement the chart.
```
Remember to install the Recharts library: 
```bash
npm install recharts
```

Test the project:
```bash
npm run dev
```

### 6. Integrate the table and the chart
Prompt:
```
Modify the application to display both the `AvocadoTable` and `AvocadoChart` components on the same page. Ensure both components share the same state for the filtered data.
```

### 7. Improve the design
Prompt:
```
Apply modern styles to the application. Make sure the table and chart are responsive and that the design is consistent with a dark background.
```

## How to Run the Project

1. Clone this repository to your local machine:
   ```bash
   git clone <REPOSITORY_URL>
   ```
2. Navigate to the project directory:
   ```bash
   cd copilot-react
   ```
3. Install the dependencies:
   ```bash
   npm install
   ```
4. Start the development server:
   ```bash
   npm run dev
   ```
5. Open your browser and go to `http://localhost:5173` to see the application in action.
