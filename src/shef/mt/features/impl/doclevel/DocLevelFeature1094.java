/**
 *
 */
package shef.mt.features.impl.doclevel;

import java.util.HashSet;

import shef.mt.features.impl.DocLevelFeature;
import shef.mt.features.util.Doc;
import shef.mt.features.util.Sentence;

/**
 *
 * ratio of percentage of pronouns in the source and target
 *
 * @author cat
 *
 */
public class DocLevelFeature1094 extends DocLevelFeature {

    public DocLevelFeature1094() {
        setIndex(1094);
        setDescription("ratio of percentage of pronouns in the source and target");
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
        float noWords = 0;
        float noContent = 0;
        for (int i=0;i<source.getSentences().size();i++){
            noContent+=(Integer) source.getSentence(i).getValue("prons");
            noWords+=source.getSentence(i).getNoTokens();
        }
        
        float perc1 = (float) noContent / noWords;
        noContent=0;
        noWords=0;
        for (int i=0;i<target.getSentences().size();i++){
            noWords = target.getSentence(i).getNoTokens();
            noContent = (Integer) target.getSentence(i).getValue("prons");
        }
        float perc2 = (float) noContent / noWords;
        if (perc2 == 0) {
            setValue(0);
        } else {
            setValue(perc1 / perc2);
        }
    }
}
