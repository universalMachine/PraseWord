package wang.praseDoc.htmlTags;

public class ClosedNodeTag extends NodeTag {
    public ClosedNodeTag(String tagName) {
        super(tagName);
    }
    @Override
    public String render() {
        String result = "";
        return result
                + genIndent()
                + genLeftTag();
    }

    @Override
    String genLeftTag() {
        return new StringBuffer()
                .append(TAG_START)
                .append(regularFormatTagName())
                .append(seperateWithAttributs())
                .append(genTagAttributes())
                .append(CLOSE_SLASH)
                .append(TAG_END)
                .toString();
    }
}
