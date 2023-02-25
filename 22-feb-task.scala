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

// DBTITLE 1,Reading of file into DataFrame
//def fileimport(path:String, format:String): DataFrame = {

val df1 = spark.read.format(format1).option("header","true").option("inferschema","true").load(csvpath)


// COMMAND ----------

// DBTITLE 1,Define function for filepath and fileformat
def fileimport(path:String, format:String) {
      val df2 = spark.read.format(format1).option("header","true").option("inferschema","true").load(csvpath)
      df2.printSchema
     }


// COMMAND ----------

 val demo = fileimport(csvpath,format1) //call the function to display the schema


// COMMAND ----------

 val df3 = spark.read.format(format1).option("header","true").option("inferschema","true").load(csvpath)

// COMMAND ----------

// DBTITLE 1,Create a Temporary view of the table
df3.createOrReplaceTempView("owid_covid_data.csv")
display (df3.take(100)) //to display first 100 records


// COMMAND ----------

// DBTITLE 1,Display continent wise total_cases
display (df3.groupBy("continent").agg(sum("total_cases")))

// COMMAND ----------

// DBTITLE 1,Display location wise total_cases
display (df3.groupBy("location").agg(sum("total_cases")))

// COMMAND ----------

val dfYear = df3.withColumn("year", year(to_date(col("date"), "dd/MM/yyyy")))
display(dfYear)

// COMMAND ----------

// DBTITLE 1,Display maximum cases groupby year and location
val maxcases = dfYear.groupBy("year", "location").agg(sum("total_cases").alias("total_cases")).orderBy(desc("total_cases"))
display (maxcases)


// COMMAND ----------

// DBTITLE 1,Display good handwash facilities location wise
val checklocation = dfYear.groupBy("location").agg(sum("handwashing_facilities").alias("handwashing_facilities")).orderBy(desc("handwashing_facilities"))
display(checklocation)

// COMMAND ----------

val Year = dfYear.select("year").distinct()
display (year)


// COMMAND ----------


