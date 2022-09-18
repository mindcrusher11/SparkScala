package org.bgc.uk
package service

import iservice.IProcessFile

import org.apache.spark.sql.DataFrame
import org.bgc.uk.config.SparkConfig

/** An object class which implements IProcessFile to add spark implementatin of
  * reading tsv files
  *
  * @author
  *   Gaurhari
  */
object SparkProcessFile extends IProcessFile {

  /**
   * A function to read tsv data using spark
   *
   * @return DataFrame
   * */
  def getTSVData(path: String): DataFrame = {
    val segments = SparkConfig.getSparkSession.read
      .option("sep", "\t")
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(path)
    segments
  }
}
