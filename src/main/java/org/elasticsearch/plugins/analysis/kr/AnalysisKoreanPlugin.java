package org.elasticsearch.plugins.analysis.kr;

import org.elasticsearch.index.analysis.KoreanAnalyzerProvider;
import org.elasticsearch.index.analysis.KoreanFilterFactory;
import org.elasticsearch.index.analysis.KoreanTokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.Plugin;

public class AnalysisKoreanPlugin extends Plugin {

    @Override
    public String name() {
            return "analysis-korean";
        }   

    @Override
    public String description() {
            return "Korean analysis support";
        }   
/*   
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
*/
    /**
     * Automatically called with the analysis module.
     */
	public void onModule(AnalysisModule module) {
		module.registerTokenFilter("kr_filter", KoreanFilterFactory::new);
		module.registerTokenizer("kr_tokenizer", KoreanTokenizerFactory::new);
		module.registerAnalyzer("kr_analyzer", KoreanAnalyzerProvider::new);
	}
      
}
