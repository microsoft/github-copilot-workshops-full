from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder \
    .appName("Bronze to Silver Transformation") \
    .getOrCreate()

def bronze_to_silver(df):
    # Define schema
    schema = ["OrderID", "OrderLine", "OrderDate", "CustomerName", "Email", "Product", "Quantity", "Price", "Tax"]
    # Apply schema to DataFrame
    df = df.toDF(*schema)
    return df

# Load the dataset (Bronze Layer)
df_bronze = spark.read.csv("datasets/2021.csv", header=False)

# Transform Bronze to Silver
df_silver = bronze_to_silver(df_bronze)
df_silver.write.csv("datasets/silver_2021.csv", header=True)

# Stop the Spark session
spark.stop()
