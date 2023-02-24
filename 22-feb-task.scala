// Databricks notebook source
// DBTITLE 1,Import packages for covid data analysis
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.Column
import org.apache.spark.sql.types._
import org.apache.log4j.Logger


// COMMAND ----------

// DBTITLE 1,Variable declaration 

val csvpath = "dbfs:/FileStore/shared_uploads/nirata.sinha@kpipartners.com/owid_covid_data.csv"
val format1 ="csv"


// COMMAND ----------

//def fileimport(path:String, format:String): DataFrame = {

val df1 = spark.read.format(format1).option("header","true").option("inferschema","true").load(csvpath)


// COMMAND ----------

def fileimport(path:String, format:String) {
      val df2 = spark.read.format(format1).option("header","true").option("inferschema","true").load(csvpath)
      df2.printSchema
  }


// COMMAND ----------

 var demo = fileimport(csvpath,format1)


// COMMAND ----------

 val df3 = spark.read.format(format1).option("header","true").option("inferschema","true").load(csvpath)

// COMMAND ----------

df3.createOrReplaceTempView("covid_data")


// COMMAND ----------

// MAGIC %sql
// MAGIC select * from covid_data;

// COMMAND ----------


