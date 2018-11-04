package wang.praseDoc.htmlTags;

import java.util.ArrayList;
import java.util.Iterator;

public class NodeTag extends HtmlTag {
    public NodeTag(String tagName) {
        this.tagName = tagName;
    }
    @Override
    public String render(){
        String result = "";
        return result
                + genIndent()
                + genLeftTag()
                + NEW_LINE
                + genChildrenTags()
                + rightNewLine()
                + genIndent()
                + genRightTag();

    };

    public  void setClasses(ArrayList<String> classes){
        this.classes = classes;
    }

    String genLeftTag(){
       return new StringBuffer()
               .append(TAG_START)
               .append(regularFormatTagName())
               .append(seperateWithAttributs())
               .append(genTagAttributes())
               .append(TAG_END)
               .toString();
   }
    String seperateWithAttributs(){
        return this.classes.size() > 0?WHITE_SPACE: EMPTY_STRING;
    }
    String regularFormatTagName(){
        this.tagName = this.tagName.trim().toLowerCase();
        return this.tagName;
    }

    String genTagAttributes(){
       return this.genClassAttribute();
   }

    String genClassAttribute(){
        String classAttribute = "";
        if(this.classes.size() >0 ){
            classAttribute = "class=\"";
            Iterator<String> classIter = this.classes.iterator();
            String firstClass = classIter.next();
            classAttribute += firstClass;
            while(classIter.hasNext()){
                classAttribute += WHITE_SPACE + classIter.next();
            }
            classAttribute += "\"";
        }
         return classAttribute;
    }

    String genChildrenTags(){
         String childrenTags = "";
         for(HtmlTag child: children){
             preFormatChild(child);
             childrenTags += child.render();
         }
         return childrenTags;
    }

    void preFormatChild(HtmlTag child){
        child.addIndent();
    }

    String rightNewLine(){
        return children.size()>0? NEW_LINE: EMPTY_STRING;
    }

    String genRightTag(){
        return new StringBuffer()
                .append(TAG_START)
                .append(CLOSE_SLASH)
                .append(regularFormatTagName())
                .append(TAG_END)
                .toString();
    }



    void appendChild(HtmlTag htmlTag){
       this.children.add(htmlTag);
   }
}
