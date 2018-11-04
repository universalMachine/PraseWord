package wang.praseDoc.htmlTags;

import org.junit.Test;
import wang.praseDoc.Utils;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NodeTagTest {
    NodeTag nodeTag;
    @Test
    public void divGenerateRightTag(){
        NodeTag divTag = new NodeTag("div");
        assertEquals("</div>", divTag.genRightTag());
    }
    @Test
    public void pGenerateRightTag(){
        NodeTag divTag = new NodeTag("p");
        assertEquals("</p>", divTag.genRightTag());
    }
    @Test
    public void upperPGenerateRightTag(){
        NodeTag pTag = new NodeTag("P");
        assertEquals("</p>", pTag.genRightTag());
    }
    @Test
    public void upperAndSpacePGenerateRightTag(){
        NodeTag pTag = new NodeTag(" P ");
        assertEquals("</p>", pTag.genRightTag());
    }
    @Test
    public void genClassAttribute(){
        NodeTag pTag = new NodeTag(" P ");
        pTag.setClasses(Utils.createArrayList("expand","container","help-img"));
        assertEquals("class=\"expand container help-img\"", pTag.genTagAttributes());
    }
    @Test
    public void SeperateWithAttributs(){
        NodeTag pTag = new NodeTag(" P ");
        assertEquals("", pTag.seperateWithAttributs());
    }
    @Test
    public void genLeftTag(){
        NodeTag pTag = new NodeTag(" P ");
        assertEquals("<p>", pTag.genLeftTag());
    }
    @Test
    public void genClassesLeftTag(){
        NodeTag pTag = new NodeTag(" P ");
        pTag.setClasses(Utils.createArrayList("expand","container","help-img"));
        assertEquals("<p class=\"expand container help-img\">", pTag.genLeftTag());
    }
    @Test
    public void addTwoNumIndent(){
        NodeTag pTag = new NodeTag(" P ");
        pTag.addIndent();
        pTag.addIndent();
        assertEquals(2, pTag.indent_num);
    }
    @Test
    public void genOneNumIndent(){
        NodeTag pTag = new NodeTag(" P ");
        pTag.addIndent();
        assertEquals("    ", pTag.genIndent());
    }
    @Test
    public void genTwoNumIndent(){
        NodeTag pTag = new NodeTag(" P ");
        pTag.addIndent();
        pTag.addIndent();
        assertEquals("        ", pTag.genIndent());
    }
    @Test
    public void renderP(){
        NodeTag pTag = new NodeTag(" P ");
        assertEquals("<p>\n</p>", pTag.render());
    }
    @Test
    public void renderPWithOneNumIndent(){
        NodeTag pTag = new NodeTag(" P ");
        pTag.addIndent();
        assertEquals("    <p>\n    </p>", pTag.render());
    }
    @Test
    public void appendChild(){
        NodeTag divTag = new NodeTag("div");
        NodeTag pTag = new NodeTag(" P ");
        divTag.appendChild(pTag);
        assertEquals("    <p>\n    </p>", divTag.genChildrenTags());
    }
    @Test
    public void renderWithOnePChild(){
        NodeTag divTag = new NodeTag("div");
        NodeTag pTag = new NodeTag(" P ");
        divTag.appendChild(pTag);
        assertEquals("<div>\n    <p>\n    </p>\n</div>", divTag.render());
    }
    @Test
    public void renderWithOneImgChild(){
        NodeTag divTag = new NodeTag("div");
        NodeTag imgTag = new ImgTag();
        divTag.appendChild(imgTag);
        assertEquals("<div>\n    <img/>\n</div>", divTag.render());
    }
    @Test
    public void renderPtagWithTextNode(){
        NodeTag pTag = new PTag();
        TextTag textTag = new TextTag("it's a content");
        pTag.appendChild(textTag);
        assertEquals("<p>\n    it's a content\n</p>", pTag.render());
    }
    @Test
    public void renderComponent(){
        DivTag divTag = new DivTag();
        ImgTag imgTag = new ImgTag();
        imgTag.setClasses(Utils.createArrayList("help-img"));
        NodeTag pTag = new PTag();
        TextTag textTag = new TextTag("it's a content");
        pTag.appendChild(textTag);
        divTag.appendChild(pTag);
        divTag.appendChild(imgTag);
        assertEquals("<p>\n    it's a content\n</p>", divTag.render());
    }
}