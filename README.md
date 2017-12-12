Korean Analysis for ElasticSearch 6.0.1
==================================

The Korean Analysis plugin integrates Lucene Korean analysis module into elasticsearch.

### Install plugin
In order to install the plugin, git clone and copy:
```
$ git clone https://github.com/usemodj/elasticsearch-analysis-korean.git
$ cd elasticsearch-analysis-korean/
$ sudo cp -R dist/analysis-korean /usr/share/elasticsearch/plugins/
```

And restart elasticsearch service:
```
$ sudo service elasticsearch restart
...
$ sudo service elasticsearch status
```

### Check elasticsearch version:
```
$ curl -XGET 'localhost:9200'
```
>```
> # print the elasticsearch version
> {
>   "name" : "DGJeJk2",
>   "cluster_name" : "elasticsearch",
>   "cluster_uuid" : "p-XSaQChSPymZ6QCzb1D_g",
>   "version" : {
>     "number" : "6.0.1",
>     "build_hash" : "601be4a",
>     "build_date" : "2017-12-04T09:29:09.525Z",
>     "build_snapshot" : false,
>     "lucene_version" : "7.0.1",
>     "minimum_wire_compatibility_version" : "5.6.0",
>     "minimum_index_compatibility_version" : "5.0.0"
>   },
>   "tagline" : "You Know, for Search"
> }
>```

### test elasticseach korean analysis

```
$ curl -XDELETE localhost:9200/test
$
$ curl -X PUT http://localhost:9200/test -d '{
  "settings": {
      "analysis": {
        "analyzer": {
          "kr_analyzer": {
            "type": "custom",
            "tokenizer": "kr_tokenizer",
            "filter": [ "trim", "kr_filter" ]
          }
        }
      }
  }
}'

$
$ curl -XGET 'localhost:9200/test/_analyze?analyzer=kr_analyzer&pretty=1' -d '아버지가 가방에 들어가셨다.'
```

> Result:
>```
> {
>   "tokens" : [ {
>     "token" : "아버지가",
>     "start_offset" : 0,
>     "end_offset" : 4,
>     "type" : "word",
>     "position" : 0
>   }, {
>     "token" : "아버지",
>     "start_offset" : 0,
>     "end_offset" : 3,
>     "type" : "word",
>     "position" : 0
>   }, {
>     "token" : "가방에",
>     "start_offset" : 5,
>     "end_offset" : 8,
>     "type" : "word",
>     "position" : 1
>   }, {
>     "token" : "가방",
>     "start_offset" : 5,
>     "end_offset" : 7,
>     "type" : "word",
>     "position" : 1
>   }, {
>     "token" : "들어가셨다",
>     "start_offset" : 9,
>     "end_offset" : 14,
>     "type" : "word",
>     "position" : 2
>   } ]
> }
>```

The plugin includes the `kr_analyzer` analyzer, `kr_tokenizer` tokenizer, and `kr_filter` token filter.


------------------
### Build source code

1. Installing Apache Maven:
* Ensure `JAVA_HOME` environment variable is set and points to your JDK installation
* Extract distribution archive in `/opt/` directory
* Add the `bin` directory of the created directory `apache-maven-3.5.2` to the `PATH` environment variable

```
$ echo $JAVA_HOME
/usr/lib/jvm/java-9-oracle

$ wget http://mirror.apache-kr.org/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.tar.gz
$ tar xzvf apache-maven-3.5.2-bin.tar.gz
$ sudo mv apache-maven-3.5.2 /opt/
 
$ echo 'export PATH="/opt/apache-maven-3.5.2/bin:$PATH"' >> ~/.bashrc
$ source ~/.bashrc

# Check maven:
$ mvn -v

Maven home: /opt/apache-maven-3.5.2
Java version: 9.0.1, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-9-oracle
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.10.0-42-generic", arch: "amd64", family: "unix"

```

2. Building analysis-korean 6.0.1 :
```
$ mvn verify
```
