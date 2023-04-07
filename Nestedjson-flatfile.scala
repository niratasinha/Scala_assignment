// Databricks notebook source
import org.apache.spark.sql.functions._
import spark.implicits._

// COMMAND ----------

val json ="""
{
    "id": "0001",
    "type": "donut",
    "name": "Cake",
    "ppu": 0.55,
    "batters":
        {
            "batter":
                [
                    { "id": "1001", "type": "Regular" },
                    { "id": "1002", "type": "Chocolate" },
                    { "id": "1003", "type": "Blueberry" },
                    { "id": "1004", "type": "Devil's Food" }
                ]
        },
    "topping":
        [
            { "id": "5001", "type": "None" },
            { "id": "5002", "type": "Glazed" },
            { "id": "5005", "type": "Sugar" },
            { "id": "5007", "type": "Powdered Sugar" },
            { "id": "5006", "type": "Chocolate with Sprinkles" },
            { "id": "5003", "type": "Chocolate" },
            { "id": "5004", "type": "Maple" }
        ]
}
"""

// COMMAND ----------

val DF= spark.read.json(spark.createDataset(json :: Nil))

// COMMAND ----------

display (DF)

// COMMAND ----------

display(DF.select($"id" as "main_id",$"name",$"batters",$"ppu",explode($"topping")) // Exploding the topping column using explode as it is an array type
        .withColumn("topping_id",$"col.id") // Extracting topping_id from col using DOT form
        .withColumn("topping_type",$"col.type") // Extracting topping_tytpe from col using DOT form
        .drop($"col")
        .select($"*",$"batters.*") // Flattened the struct type batters tto array type which is batter
        .drop($"batters")
        .select($"*",explode($"batter"))
        .drop($"batter")
        .withColumn("batter_id",$"col.id") // Extracting batter_id from col using DOT form
        .withColumn("battter_type",$"col.type") // Extracting battter_type from col using DOT form
        .drop($"col")
       )
