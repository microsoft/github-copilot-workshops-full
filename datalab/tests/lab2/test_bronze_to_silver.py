import pytest
from pyspark.sql import SparkSession

@pytest.fixture(scope="module")
def spark():
    return SparkSession.builder \
        .appName("Bronze to Silver Transformation Test") \
        .getOrCreate()

@pytest.fixture(scope="module")
def bronze_df(spark):
    # Load the bronze dataset
    df = spark.read.csv("datasets/2021.csv", header=False)
    return df

@pytest.fixture(scope="module")
def silver_df(spark):
    # Load the silver dataset
    df = spark.read.csv("datasets/silver_2021.csv", header=True)
    return df

def test_bronze_to_silver_schema(silver_df):
    expected_schema = ["OrderID", "OrderLine", "OrderDate", "CustomerName", "Email", "Product", "Quantity", "Price", "Tax"]
    assert silver_df.columns == expected_schema
