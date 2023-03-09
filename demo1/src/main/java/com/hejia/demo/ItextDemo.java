package com.hejia.demo;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.font.otf.GlyphLine;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.property.Property;
import com.itextpdf.layout.splitting.DefaultSplitCharacters;
import org.apache.http.util.ExceptionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: hj
 * @Date: 2021/1/22 17:45
 */
public class ItextDemo {
    private static final FontProvider PROVIDER = new FontProvider();

    static {
        PROVIDER.addSystemFonts();
    }

    private static void convertHtmlToPdf(InputStream in, OutputStream out) {
        ConverterProperties properties = new ConverterProperties();
        properties.setFontProvider(PROVIDER);
        properties.setCharset("UTF-8");
        // 打印pdf
        com.itextpdf.layout.Document document = null;
        try {
            PdfWriter writer = new PdfWriter(out);
            PdfDocument pdfDocument = new PdfDocument(writer);

            document = HtmlConverter.convertToDocument(in, pdfDocument, properties);
            document.setProperty(Property.SPLIT_CHARACTERS, new DefaultSplitCharacters() {
                @Override
                public boolean isSplitCharacter(GlyphLine text, int glyphPos) {
                    // return super.isSplitCharacter(text, glyphPos);
                    // 解决word-break: break-all;不兼容的问题，解决纯英文或数字不自动换行的问题
                    return true;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("html转pdf失败", e);
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }
}
