# GitHub Data Transformation and Testing Lab

## Pre-requisites

- [Visual Studio Code](https://code.visualstudio.com/) or any other editor that supports GitHub Copilot.
- [GitHub Copilot](https://copilot.github.com/) extensions installed.
- [Java SDK v21](https://www.oracle.com/java/technologies/downloads/archive/) 
- [Spark Hadoop](https://spark.apache.org/docs/latest/api/python/getting_started/install.html) or use 'pip install pyspark'. 
- [PyTest](https://pypi.org/project/pytest/) or install using 'pip install pytest'.
- [Jupyter Notebook Extension](https://code.visualstudio.com/docs/datascience/jupyter-notebooks)

## Lab Overview

In this lab, you will perform data transformations using PySpark and validate these transformations using PyTest. You will also adapt the transformations to a Medallion data architecture. The goal is to understand the process of data transformation and testing, and to adapt the transformations to fit a specific data architecture. The entire lab will be done using GitHub Copilot, and you will use different prompts created by the user to guide the process.

## Situation

You have been provided with a dataset named `2021.csv` by the financial team without any information, headers, etc. in the dataset. Your task is to perform various data transformations on this dataset to make it business-valid, and to validate the data transformations. In addition, you will adapt the transformations to a Medallion data architecture.

## Lab 1 - Data Transformation and Testing

### Data Transformation

1. Load the dataset using PySpark.
2. Perform necessary data transformations based on your analysis of the data using Github Copilot.
3. Execute data transformations, check the transformations performed and save the transformed dataset as a new dataset.

### Data Transformation Testing

1. Use Github Copilot to create PyTest code and validate previously performed data transformations.
2. Ensure the transformed dataset meets the expected criteria and check the new dataset file created.

**Fix and mitigate the different bugs you have using Github Copilot!**

### Jupyter Notebook Creation

1. Create a Jupyter Notebook using Github Copilot detailing the transformations and tests.
2. Include detailed code comments to explain each step.
3. Run the Jupyter Notebook.

## Lab 2 - Medallion Workflow

### Adapt to Medallion Architecture

1. Adapt the transformations to a Medallion data architecture using Github Copilot.
2. Separate the transformations into Bronze, Silver, and Gold layers.
3. If Hadoop is available, use **parquet files** in silver and gold layer datasets.

### Split Transformation Code

1. Use Github Copilot to split the transformations into Bronze, Silver, and Gold layers code, creating new datasets in each step based on different transformation.
3. Run the complete transformation code workflow: Bronze -> Silver, Silver -> Gold.

### Split Test Code

1. Use Github Copilot to split the test code into separate scripts for testing Bronze to Silver and Silver to Gold transformations.
2. Run the complete test code workflow: Bronze -> Silver, Silver -> Gold.
3. Fix and mitigate each 

### Jupyter Notebook Creation

1. Create a new Jupyter Notebook detailing the Medallion workflow.
2. Include steps for Bronze to Silver transformation, testing, Silver to Gold transformation, and testing.

**Fix and mitigate the different bugs you have using Github Copilot!**

# Files

- `README.md`: Project explanation and instructions.

## Lab 1
- `transformations.py`: PySpark code to load and transform the dataset.
- `test_transformations.py`: PyTest code to validate the data transformation.
- `transformations_and_tests.ipynb`: Jupyter Notebook detailing the transformations 

## Lab 2
- `bronze_to_silver.py`: PySpark code for Bronze to Silver transformation.
- `silver_to_gold.py`: PySpark code for Silver to Gold transformation.
- `test_bronze_to_silver.py`: PyTest code to validate Bronze to Silver transformation.
- `test_silver_to_gold.py`: PyTest code to validate Silver to Gold transformation.
- `data_transformation_medallion.ipynb`: Jupyter Notebook detailing the transformations and tests step by step.


## How to Run

### Lab 1 - Data Transformation and Testing

1. Run `transformations.py` to load and transform the dataset.
2. Run `test_transformations.py` using PyTest to validate the data transformation.
3. Open `transformations_and_tests.ipynb` in Jupyter Notebook to see the detailed steps and explanations.

### Lab 2 - Medallion Workflow

1. Run `bronze_to_silver.py` to transform the Bronze layer to the Silver layer.
2. Run `silver_to_gold.py` to transform the Silver layer to the Gold layer.
3. Run `test_bronze_to_silver.py` using PyTest to validate the Bronze to Silver transformation.
4. Run `test_silver_to_gold.py` using PyTest to validate the Silver to Gold transformation.
5. Open `data_transformation_medallion.ipynb` in Jupyter Notebook to see the detailed steps and explanations.
