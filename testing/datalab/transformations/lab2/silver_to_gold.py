from pyspark.sql import SparkSession
from pyspark.sql.functions import col, split

# Initialize Spark session
spark = SparkSession.builder \
    .appName("Silver to Gold Transformation") \
    .getOrCreate()

def silver_to_gold(df):
    # Split Product column into ProductName and ProductDetails
    df = df.withColumn("ProductName", split(col("Product"), ",")[0]) \
           .withColumn("ProductDetails", split(col("Product"), ",")[1])
    # Drop the original Product column
    df = df.drop("Product")
    return df

# Load the Silver dataset
df_silver = spark.read.csv("datasets/silver_2021.csv", header=True)

# Transform Silver to Gold
df_gold = silver_to_gold(df_silver)
df_gold.write.csv("datasets/gold_2021.csv", header=True)

# Stop the Spark session
spark.stop()
