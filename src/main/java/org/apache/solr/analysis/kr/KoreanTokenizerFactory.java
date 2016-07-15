package org.apache.solr.analysis.kr;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.kr.KoreanTokenizer;
import org.apache.lucene.util.AttributeFactory;
import org.apache.lucene.util.Version;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

public class KoreanTokenizerFactory extends AbstractTokenizerFactory {

	private Version version;
	
	public KoreanTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
		version = Version.LUCENE_6_0_0;
	}

	@Override
	public Tokenizer create() {
		return new KoreanTokenizer(version);
	}

}
