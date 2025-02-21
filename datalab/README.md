# Github Copilot Data Transformation and Testing Labs

## Lab Explanation

This labs demonstrates the process of data transformation using PySpark and validates the transformations using PyTest using Github Copilot throughout the process. The demo dataset provided by the financial team contains order details for the year 2021 but without relevant information such as headers or explanation of the data (to be obtained by GH Copilot during the code creation process). The goal is to perform various data transformations and ensure the integrity of the transformed data using Github Copilot, making the process simpler and reducing code creation times.

## Situation

The financial team has provided a dataset named `2021.csv` and requires us to perform various data transformations and testing operations on these transformations. The transformations include splitting the `Product` column into `ProductName` and `ProductDetails`, and validating the transformed data using PyTest.

## Lab 1 - Data transformation and testing using GH Copilot

1. **Data Transformation:**
   ```
   The financial team has provided a dataset named 2021.csv and requires us to perform various data transformations and testing operations on these transformations.Project requirements:

   Data Transformation:

   - Use PySpark to load and transform the dataset.
   - Implement necessary data transformations code based on your analysis of the data.
   ```

2. **Data Transformation Testing:**
   ```
   The next phase is to check the data transformation performed, so generate with pytest a code to validate this data transformation.
   ```

3. **Jupyter Notebook Creation:**
   ```
   We will generate a Jupyter Notebook with the transformations and tests. Detail it step by step with detailed code comments so that the Data team can explain it in detail to Finance.
   ```

## Lab 2 - Medallion Workflow

It seems that our manager was happy with the code used, but it does not fit with the data transformation architecture used by the company, which is Medallion. We are going to use Github Copilot to fix that!

To adapt the transformations to a Medallion data transformation architecture, the following prompts were used:

1. **Adapt to Medallion Architecture:**
   ```
   Reviewing the project, my manager wants to adapt the transformations to a Medallion data transformation architecture.

   For this, the raw data (2021.csv) will be the bronze layer, and the following transformations will be the Silver Layer and Gold Layer.

   Adapt and transform the project to this architecture by creating the code you need, and separate the tests so that it tests on one side the transformations from bronze to silver, and from silver to gold.
   ```

   If Hadoop is available, use **parquet file** in silver and gold layer datasets.

2. **Split Transformation Code:**
   ```
   Split the code ‘transformation.py’ into 2 different codes for the transformation bronze to silver, and silver to gold, so that we can execute them at different stages of the pipeline.
   ```

3. **Split Test Code:**
   ```
   Split the code ‘test_transformatons.py’ into 2 different codes for the test bronze to silver transformation, and silver to gold transformation, so that we can execute them at different stages of the pipeline.
   ```

3. **Jupyter Notebook Creation:**
   ```
   Create a detailed new Jupyter notebook using the following steps:

      1.Bronze to silver transformation.
      2.Testing the bronze to silver transformation.
      3.Silver to gold transformation.
      4.Test the silver to gold transformation.
      
   Detailed information on all steps and comments.
   ```


## Files

- `transformations.py`: Contains the PySpark code to load and transform the dataset.
- `test_transformations.py`: Contains the pytest code to validate the data transformation.
- `bronze_to_silver.py`: Contains the PySpark code for the Bronze to Silver transformation.
- `silver_to_gold.py`: Contains the PySpark code for the Silver to Gold transformation.
- `test_bronze_to_silver.py`: Contains the pytest code to validate the Bronze to Silver transformation.
- `test_silver_to_gold.py`: Contains the pytest code to validate the Silver to Gold transformation.
- `transformations_and_tests.ipynb`: A Jupyter Notebook detailing the transformations and tests step by step.
- `README.md`: This file, explaining the project, situation, and prompts used during the code creation.

## How to Run

## Lab 1 - Data transformation and testing using GH Copilot

1. **Data Transformation:**
   - Run `transformations.py` to load and transform the dataset.
   
        ```python transformation.py```
   
   - The transformed dataset will be saved as `transformed_2021.csv`.

2. **Data Transformation Testing:**
   - Run `test_transformations.py` using pytest to validate the data transformation.

        ```pytest test_transformation.py```
   
   - Ensure that the transformed dataset is located at the specified path in the test file.

3. **Jupyter Notebook:**
   - Open `transformations_and_tests.ipynb` in Jupyter Notebook to see the detailed steps and explanations of the transformations and tests.

## Lab 2 - Medallion Workflow

1. **Medallion Workflow:**
   - Run `bronze_to_silver.py` to transform the Bronze layer to the Silver layer.
   
        ```python bronze_to_silver.py```
   
   - Run `silver_to_gold.py` to transform the Silver layer to the Gold layer.
   
        ```python silver_to_gold.py```

2. **Medallion Workflow Testing:**
   - Run `test_bronze_to_silver.py` using pytest to validate the Bronze to Silver transformation.
   
        ```pytest test_bronze_to_silver.py```
   
   - Run `test_silver_to_gold.py` using pytest to validate the Silver to Gold transformation.
   
        ```pytest test_silver_to_gold.py```

3. **Jupyter Notebook:**
   - Open `transformations_and_tests.ipynb` in Jupyter Notebook to see the detailed steps and explanations of the transformations and tests.