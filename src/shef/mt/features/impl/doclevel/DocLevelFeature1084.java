/**
 *
 */
package shef.mt.features.impl.doclevel;

import shef.mt.features.impl.DocLevelFeature;
import java.util.*;
import shef.mt.features.util.Doc;
import shef.mt.features.util.Sentence;

/**
 *
 * percentage of content words in the source
 *
 * @author cat
 *
 */
public class DocLevelFeature1084 extends DocLevelFeature {

    public DocLevelFeature1084() {
        setIndex(1084);
        setDescription("percentage of content words in the source");
        this.addResource("postagger");
        
    }

    /* (non-Javadoc)
     * @see wlv.mt.features.impl.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
     */
    @Override
    public void run(Sentence source, Sentence target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run(Doc source, Doc target) {
        float noContent =0;
        float noWords =0;
        for(int i=0;i<source.getSentences().size();i++){
            noWords+= source.getSentence(i).getNoTokens();
            noContent+= (Integer) source.getSentence(i).getValue("contentWords");
        }
        setValue(noContent / noWords);
    }
}
