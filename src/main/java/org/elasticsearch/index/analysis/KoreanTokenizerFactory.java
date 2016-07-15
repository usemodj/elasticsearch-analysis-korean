package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.kr.KoreanTokenizer;
import org.apache.lucene.util.Version;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

public class KoreanTokenizerFactory extends AbstractTokenizerFactory {
  @Inject
  public KoreanTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
      super(indexSettings, name, settings);
  }

	@Override
	public Tokenizer create() {
	    return new KoreanTokenizer(Version.LUCENE_6_0_0);
	}   
}
