Korean Analysis for ElasticSearch 5.0.0-alpha3
==================================

The Korean Analysis plugin integrates Lucene Korean analysis module into elasticsearch.

### Install plugin
In order to install the plugin, git clone and copy: 
```
sudo cp dist/analysis-korean /usr/share/elasticsearch/plugins/

```

And restart elasticsearch service:
```
sudo service elasticsearch restart
...
sudo service elasticsearch status
```

### test elasticseach korean analysis

```
curl -XDELETE localhost:9200/test

curl -X PUT http://localhost:9200/test -d '{
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

curl -XGET 'localhost:9200/test/_analyze?analyzer=kr_analyzer&pretty=1' -d '아버지가 가방에 들어가셨다.'

```

>>Result:
```
{
  "tokens" : [ {
    "token" : "아버지가",
    "start_offset" : 0,
    "end_offset" : 4,
    "type" : "word",
    "position" : 0
  }, {
    "token" : "아버지",
    "start_offset" : 0,
    "end_offset" : 3,
    "type" : "word",
    "position" : 0
  }, {
    "token" : "가방에",
    "start_offset" : 5,
    "end_offset" : 8,
    "type" : "word",
    "position" : 1
  }, {
    "token" : "가방",
    "start_offset" : 5,
    "end_offset" : 7,
    "type" : "word",
    "position" : 1
  }, {
    "token" : "들어가셨다",
    "start_offset" : 9,
    "end_offset" : 14,
    "type" : "word",
    "position" : 2
  } ]
}

```

The plugin includes the `kr_analyzer` analyzer, `kr_tokenizer` tokenizer, and `kr_filter` token filter.



