import com.itextpdf.text.DocumentException;
import freemarker.template.TemplateException;
import pdf.PdfTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yitingq on 2018/11/30.
 */
public class Test {
    private final static String TEST_TEMPLATE_NAME = "test.ftl";

    public static void main(String[] args) throws IOException, DocumentException, TemplateException {
        Map<String,Object> dataMap = new HashMap<>();

        List<Map<String,Object>> list = new ArrayList<>();

        for(int i=0;i<20;){
            Map<String,Object> map = new HashMap<>();
            map.put("a",i++);
            map.put("b",i++);

            list.add(map);
        }

        dataMap.put("paragraph","测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本测试文本");
        dataMap.put("testList",list);

        FileOutputStream fos = new FileOutputStream(new File("D:\\test2.pdf"));
        PdfTemplateUtils.createPdfByTemplate(TEST_TEMPLATE_NAME,dataMap,fos);
    }
}
