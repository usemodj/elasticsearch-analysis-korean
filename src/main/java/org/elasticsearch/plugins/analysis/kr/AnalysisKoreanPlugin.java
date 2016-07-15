package org.elasticsearch.plugins.analysis.kr;

import java.util.Map;
import static java.util.Collections.singletonMap;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.KoreanAnalyzerProvider;
import org.elasticsearch.index.analysis.KoreanFilterFactory;
import org.elasticsearch.index.analysis.KoreanTokenizerFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

public class AnalysisKoreanPlugin extends Plugin implements AnalysisPlugin {

  
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
//        Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
//        extra.put("kr_filter", KoreanFilterFactory::new);
//        return extra;
        return singletonMap("kr_filter", KoreanFilterFactory::new);
    }

    
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        return singletonMap("kr_tokenizer", KoreanTokenizerFactory::new);
    }

    
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return singletonMap("kr_analyzer", KoreanAnalyzerProvider::new);
    }

}
