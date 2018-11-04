package wang.praseDoc.htmlTags;

public class TextTag extends HtmlTag{
    protected  String innerText = "";

    public TextTag(String innerText) {
        this.innerText = innerText;
    }

    @Override
    public String render() {
        return new StringBuffer()
                .append(genIndent())
                .append(innerText)
                .toString();
    }

}
