package org.elasticsearch.index.analysis;
 
import java.io.IOException;

import org.apache.lucene.analysis.kr.KoreanAnalyzer;
import org.apache.lucene.util.Version;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

public class KoreanAnalyzerProvider extends AbstractIndexAnalyzerProvider<KoreanAnalyzer> {

    private final KoreanAnalyzer analyzer;

    public KoreanAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) throws IOException {
        super(indexSettings, name, settings);
        analyzer = new KoreanAnalyzer(Version.LUCENE_6_0_0);
    }       

    @Override
    public KoreanAnalyzer get() {
            return this.analyzer;
        }       
}
