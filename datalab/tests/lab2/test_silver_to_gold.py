import pytest
from pyspark.sql import SparkSession
from pyspark.sql.functions import col

@pytest.fixture(scope="module")
def spark():
    return SparkSession.builder \
        .appName("Silver to Gold Transformation Test") \
        .getOrCreate()

@pytest.fixture(scope="module")
def gold_df(spark):
    # Load the gold dataset
    df = spark.read.csv("datasets/gold_2021.csv", header=True)
    return df

def test_silver_to_gold_schema(gold_df):
    expected_schema = ["OrderID", "OrderLine", "OrderDate", "CustomerName", "Email", "Quantity", "Price", "Tax", "ProductName", "ProductDetails"]
    assert gold_df.columns == expected_schema

def test_product_split(gold_df):
    sample_row = gold_df.filter(col("OrderID") == "SO49171").collect()[0]
    assert sample_row["ProductName"] == "Road-250 Black"
    assert sample_row["ProductDetails"].strip() == "48"

def test_row_count(gold_df):
    original_row_count = 28784  
    assert gold_df.count() == original_row_count

def test_data_integrity(gold_df):
    sample_row = gold_df.filter(col("OrderID") == "SO49171").collect()[0]
    assert sample_row["CustomerName"] == "Mariah Foster"
    assert sample_row["Email"] == "mariah21@adventure-works.com"
    assert sample_row["Quantity"] == "1"
    assert sample_row["Price"] == "2181.5625"
    assert sample_row["Tax"] == "174.525"
