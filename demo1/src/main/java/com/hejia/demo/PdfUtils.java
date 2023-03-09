package wp.util;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
/**
 * Created by wangpeng on 2018/02/01.
 */
public class PdfUtils {
    // 利用模板生成pdf
    public static void pdfout(Map<String,Object> o) {
        // 模板路径
        String templatePath = "D:\\test\\explorationWordTemplateAdobe.pdf";
        // 生成的新文件路径
        String newPDFPath = "D:\\test\\testout1.pdf";

        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            BaseFont bf = BaseFont.createFont("c://windows//fonts//simsun.ttc,1" , BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font FontChinese = new Font(bf, 5, Font.NORMAL);
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            //文字类的内容处理
            Map<String,String> datemap = (Map<String,String>)o.get("datemap");
            form.addSubstitutionFont(bf);
            for(String key : datemap.keySet()){
                String value = datemap.get(key);
                form.setField(key,value);
            }
            //图片类的内容处理
            Map<String,String> imgmap = (Map<String,String>)o.get("imgmap");
            for(String key : imgmap.keySet()) {
                String value = imgmap.get(key);
                String imgpath = value;
                int pageNo = form.getFieldPositions(key).get(0).page;
                Rectangle signRect = form.getFieldPositions(key).get(0).position;
                float x = signRect.getLeft();
                float y = signRect.getBottom();
                //根据路径读取图片
                Image image = Image.getInstance(imgpath);
                //获取图片页面
                PdfContentByte under = stamper.getOverContent(pageNo);
                //图片大小自适应
                image.scaleToFit(signRect.getWidth(), signRect.getHeight());
                //添加图片
                image.setAbsolutePosition(x, y);
                under.addImage(image);
            }
            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.close();
            Document doc = new Document();
            Font font = new Font(bf, 32);
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(e);
        } catch (DocumentException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        map.put("permitNo","5301110040137");
        map.put("expirationTime","2018-1-1～2018-1-1");
        map.put("projectName","官渡区大麦地石灰石矿区尚学新矿点");
        map.put("area","13.2");
        map.put("location","官渡区大麦地石灰石矿区");
        map.put("varietyName","石灰石");
        map.put("settlingTime","2018-1-1");
        map.put("year1","2018");
        map.put("area1","0.21");
        map.put("permitNo1","5301110040137");
        map.put("chargeTime1","2018-1-1～2018-1-1");
        map.put("dutyCharge1","200");
        map.put("rate1","0");
        map.put("actualCharge1","200");

        Map<String,String> map2 = new HashMap();
//        map2.put("img","c:/50336.jpg");

        Map<String,Object> o=new HashMap();
        o.put("datemap",map);
        o.put("imgmap",new HashMap<String, Object>());
        pdfout(o);
    }
}