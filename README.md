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


