# SparkScala
Spark Scala Code for processing IMDB data.

Download the code using command below.

```
git clone https://github.com/mindcrusher11/sparkscalabcg
```

Download Data from [IMDB Website](https://datasets.imdbws.com/) in some location and give the path in application.conf file or download in resources folder.

Use command below to download data.

```
wget https://datasets.imdbws.com/name.basics.tsv.gz
wget https://datasets.imdbws.com/title.akas.tsv.gz
wget https://datasets.imdbws.com/title.basics.tsv.gz
wget https://datasets.imdbws.com/title.crew.tsv.gz
wget https://datasets.imdbws.com/title.episode.tsv.gz
wget https://datasets.imdbws.com/title.principals.tsv.gz
wget https://datasets.imdbws.com/title.ratings.tsv.gz
```

Update Configuration settings in application.conf under file section for above files location and spark configuration in Spark section located in "src/main/resources" directory.


It will download dependencies in local.

Run Test Cases using Command below 

```
sbt test 
```

in project directory.

It will show text like as below :-

[info] MovieSchemaCheckTest:

[info] - Testing Dataframe Schema.

[info] Run completed 

[info] Total number of tests run: 1

[info] Suites: completed 1, aborted 0

[info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0

[info] All tests passed.

Scala Docs for this project can be generated using command below in current porject parent directory.
```
sbt doc
```
It will generate index.html file as "target/scala-2.11/api/index.html".

It can be opened in the browser.


Run Project Steps 👎

Create Jar File from this project

```
sbt package
```
Run application 

```
sbt run
```
Configuration file can be set in application.conf file which can be passed as an argument to the jar or in src/main/resources folder.

e.g

```
spark {
masterurl = "local[*]"
appName = "omicsspark"
checkpointDir = "./checkpoint"
batchDuration = "15"
}

file {
writeformat = "com.databricks.spark.csv"
titlePrincipalPath = "/partition/sparkscalabgc/src/main/resources/imdbdata/title.principals.tsv.gz"
titleRatingsPath = "/partition/sparkscalabgc/src/main/resources/imdbdata/title.ratings.tsv.gz"
nameBasicsPath = "/partition/sparkscalabgc/src/main/resources/imdbdata/name.basics.tsv.gz"
titleBasicsPath = "/partition/sparkscalabgc/src/main/resources/imdbdata/title.basics.tsv.gz"
}
```

For running in cluster you can change masterurl value to sparkcluster or yarn
and keep same for running on local.

appName for passing application name to SparkSession.

File location can be updated in file section accordingly.

Code can run in cluster using command below

```
spark-submit --class "SparkScalaBcgMainApp" --master local[4] .target/scala-2.11/sparkscalabgc_2.11-0.1.0-SNAPSHOT.jar path/application.conf
```

** Logging is pending
