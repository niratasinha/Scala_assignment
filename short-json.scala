// Databricks notebook source
// DBTITLE 1,First Approach
import spark.implicits._
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col,explode_outer}
import org.apache.spark.sql.types.{ArrayType, StructType}

// COMMAND ----------

val test_json = "dbfs:/FileStore/shared_uploads/nirata.sinha@kpipartners.com/test_json.txt"
val df =spark.read.option("multiline","true").json(test_json)
//df.show()
//df.printSchema()

// COMMAND ----------


def flattenDataFrame(df: DataFrame): DataFrame = {
  val fields = df.schema.fields
  val fieldNames = fields.map(x => x.name)

  for (i <- fields.indices) {
    val field = fields(i)
    val fieldType = field.dataType
    val fieldName = field.name
    fieldType match {
      case _: ArrayType =>
        val fieldNamesExcludingArray = fieldNames.filter(_ != fieldName)
        val fieldNamesAndExplode = fieldNamesExcludingArray ++ Array(
          s"explode_outer($fieldName) as $fieldName"
        )
        val explodedDf = df.selectExpr(fieldNamesAndExplode: _*)
        return flattenDataFrame(explodedDf)
      case structType: StructType =>
        val childFieldNames =
          structType.fieldNames.map(childname => s"$fieldName.$childname")
        val newFieldNames = fieldNames.filter(_ != fieldName) ++ childFieldNames

        val renamedCols =
          newFieldNames.map { x =>
            col(x.toString).as(x.toString.replace(".", "_"))
          }

        val explodedDf = df.select(renamedCols: _*)
        return flattenDataFrame(explodedDf)
      case _ =>
    }
  }

return df
}

val ls = flattenDataFrame(df)


// COMMAND ----------

display (ls)

// COMMAND ----------

// DBTITLE 1,2nd Approach
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import scala.annotation.tailrec
import scala.util.Try

//val df =spark.read.option("multiline","true").json(test_json)
implicit class DFHelpers(df: DataFrame) {
    def columns = {
      val dfColumns = df.columns.map(_.toLowerCase)
      df.schema.fields.flatMap { data =>
        data match {
          case column if column.dataType.isInstanceOf[StructType] => {
            column.dataType.asInstanceOf[StructType].fields.map { field =>
              val columnName = column.name
              val fieldName = field.name
              col(s"${columnName}.${fieldName}").as(s"${columnName}_${fieldName}")
            }.toList
          }
          case column => List(col(s"${column.name}"))
        }
      }
    }

    def flatten: DataFrame = {
      val empty = df.schema.filter(_.dataType.isInstanceOf[StructType]).isEmpty
      empty match {
        case false =>
          df.select(columns: _*).flatten
        case _ => df
      }
    }
    def explodeColumns = {
      @tailrec
      def columns(cdf: DataFrame):DataFrame = cdf.schema.fields.filter(_.dataType.typeName == "array") match {
        case c if !c.isEmpty => columns(c.foldLeft(cdf)((dfa,field) => {
          dfa.withColumn(field.name,explode_outer(col(s"${field.name}"))).flatten
        }))
        case _ => cdf
      }
      columns(df.flatten)
    }
}
df.printSchema()



// COMMAND ----------

df.explodeColumns.show()

// COMMAND ----------

df.explodeColumns.printSchema()
