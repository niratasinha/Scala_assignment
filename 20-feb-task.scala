// Databricks notebook source
// DBTITLE 1,LOADING JSON FILE INTO DATAFRAME
//Variable declaration for the file path
var path = "dbfs:/FileStore/shared_uploads/nirata.sinha@kpipartners.com/employee-3.json"
val df1 = spark.read.format("json").load(path) // reading file from DBFS


// COMMAND ----------

// DBTITLE 1,Display the table schema
df1.printSchema()

// COMMAND ----------

// DBTITLE 1,Display the table contents
display(df1)

// COMMAND ----------

// DBTITLE 1,Display the number of records
df1.count()


// COMMAND ----------

// DBTITLE 1,Display employee name with their departments
val DF=df1.select( "empname","dept")
display (DF)

// COMMAND ----------

// DBTITLE 1,Create table view to display the table contents
df1.createOrReplaceTempView("emp")
val sqldf = spark.sql("SELECT empid,empname,dept,salary,address FROM emp") //table contents stored in a variable
display (sqldf)


// COMMAND ----------

// DBTITLE 1,Display maximum salary
df1.createOrReplaceTempView("emp")

val sqldf = spark.sql("SELECT max(salary) FROM emp") 
display (sqldf)

// COMMAND ----------

// DBTITLE 1,Increase employee salary by 20000
val sqldf = spark.sql("SELECT empid,empname,dept,salary,(salary+20000) as newsal FROM emp")
display (sqldf)

// COMMAND ----------

// DBTITLE 1,Writing output file 
val out = "dbfs:/FileStore/shared_uploads/nirata.sinha@kpipartners.com/output" //output file stored in the variable
sqldf.write.format("json").save(out)

// COMMAND ----------

val outputdf = spark.read.format("json").load("dbfs:/FileStore/shared_uploads/nirata.sinha@kpipartners.com/output")

// COMMAND ----------

// DBTITLE 1,Display output file 
display(outputdf)
