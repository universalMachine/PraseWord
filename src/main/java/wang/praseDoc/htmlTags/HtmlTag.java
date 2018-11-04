package wang.praseDoc.htmlTags;

import java.util.ArrayList;

public abstract class HtmlTag {
    protected final String TAG_START = "<";
    protected final String TAG_END = ">";
    protected final String CLOSE_SLASH = "/";
    protected final String WHITE_SPACE = " ";
    protected final String NEW_LINE = "\n";
    protected final String EMPTY_STRING = "";

    protected  String innerText = "";
    protected ArrayList<String> classes = new ArrayList<>();
    protected ArrayList<HtmlTag> children = new ArrayList<>();
    protected String tagName;
    protected int indent_length = 4;
     int indent_num = 0;


   abstract public String render();
    String genIndent(){
        String result = "";
        int whiteSpaceNum = indent_num * indent_length;
        for(int i = 0; i<whiteSpaceNum ; i++){
            result += WHITE_SPACE;
        }
        return result;
    }

    void addIndent(){
        this.indent_num += 1;
    }

    ;

}
