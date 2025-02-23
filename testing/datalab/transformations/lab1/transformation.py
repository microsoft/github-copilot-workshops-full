from pyspark.sql import SparkSession
from pyspark.sql.functions import col, split
# Initialize Spark session
spark = SparkSession.builder \
    .appName("Data Transformation") \
    .getOrCreate()
# Load the dataset
df = spark.read.csv("datasets/2021.csv", header=False)
# Define schema
schema = ["OrderID", "OrderLine", "OrderDate", "CustomerName", "Email", "Product", "Quantity", "Price", "Tax"]
# Apply schema to DataFrame
df = df.toDF(*schema)
# Split Product column into ProductName and ProductDetails
df = df.withColumn("ProductName", split(col("Product"), ",")[0]) \
       .withColumn("ProductDetails", split(col("Product"), ",")[1])
# Drop the original Product column
df = df.drop("Product")
# Show transformed DataFrame
df.show()
# Save the transformed DataFrame to a new CSV file
df.write.csv("datasets/transformed_2021.csv", header=True)
# Stop the Spark session
spark.stop()