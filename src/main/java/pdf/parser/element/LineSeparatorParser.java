package pdf.parser.element;

import com.itextpdf.text.pdf.draw.LineSeparator;
import org.dom4j.Attribute;
import org.dom4j.Element;
import pdf.parser.BaseParser;
import pdf.parser.ParserUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by yitingq on 2018/11/30.
 */
public class LineSeparatorParser extends BaseParser {

    private final static LineSeparatorParser SEPARATOR_PARSER = new LineSeparatorParser();

    private LineSeparatorParser(){

    }

    public static LineSeparatorParser getInstance(){
        return SEPARATOR_PARSER;
    }

    @Override
    public Object parse(Element XmlElement, Map<String,Object> refMap) throws Exception {
        LineSeparator lineSeparator = new LineSeparator();

        Iterator attrIt = XmlElement.attributeIterator();

        while (attrIt.hasNext()){
            Attribute attr = (Attribute)attrIt.next();

            String attrName = attr.getName();
            String attrValue = attr.getValue();
            switch (attrName){
                case "offset":
                    lineSeparator.setOffset(Float.parseFloat(attrValue));
                    break;
                case "align":
                    lineSeparator.setAlignment(ParserUtils.getAlignment(attrValue));
                    break;
                case "width":
                    lineSeparator.setLineWidth(Float.parseFloat(attrValue));
                    //lineSeparator.
                    break;
                default:
                    throw new Exception("未知的LineSeparator属性：" + attrName);
            }
        }

        return lineSeparator;
    }
}
