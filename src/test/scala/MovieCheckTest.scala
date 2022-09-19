package org.bgc.uk

import service.{LoadIMDBData, SparkProcessFile}

import com.holdenkarau.spark.testing.{DataframeGenerator, SharedSparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types._
import org.bgc.uk.utils.Constants
import org.scalacheck.Prop.forAll
import org.scalatest.FunSuite
import org.scalatest.prop.Checkers

class MovieCheckTest extends FunSuite with SharedSparkContext with Checkers {

  def before(): Unit = {}

  test("Testing Dataframe Schema.") {
    val schema = StructType(
      List(
        StructField("tconst", StringType),
        StructField("averageRating", DoubleType),
        StructField("numVotes", IntegerType)
      )
    )

    val titleRatingsDF =
      SparkProcessFile.getTSVData("resources/imdbdata/title.ratings.tsv.gz")

    val property =
      forAll(titleRatingsDF) { dataframe =>
        dataframe.schema === schema
      }

    check(property)
  }

  test("Testing Top20 Movies Count.") {
    val sqlContext = new SQLContext(sc)
    val top20movies = LoadIMDBData.getTopNMovies()
    val property =
      forAll(top20movies) { dataframe =>
        dataframe
          .count() == 20
      }
    check(property)
  }

  test("testing name of often credited person of top20 movie.") {
    val sqlContext = new SQLContext(sc)
    val personOftenCredited = LoadIMDBData.getPersonsMostOftenCredited()
    val property =
      forAll(personOftenCredited) { dataframe =>
        dataframe
          .filter("nconst == 'nm0000008'")
          .select("primaryName")
          .first()(0) == "Marlon Brando"
      }
    check(property)
  }

}
