package com.hejia.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.converters.date.DateStringConverter;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.alibaba.excel.write.style.row.SimpleRowHeightStyleStrategy;
import com.hejia.demo.impl.ChangeCellFontHandler;
import com.hejia.demo.impl.ChangeHeightAndWidthHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelDemo {
    private final static String PATH_NAME = "D:\\test\\";
    private final static String EXCEL_FORMAT = ".xlsx";

    @Test
    public void test1() {
        List<List<String>> head = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("项目名称");
        List<String> head1 = new ArrayList<>();
        head1.add("文件标题");
        List<String> head2 = new ArrayList<>();
        head2.add("文件大小");
        head.add(head0);
        head.add(head1);
        head.add(head2);
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> dataList1 = new ArrayList<>();
        dataList1.add("{.projectName}");
        dataList1.add("{.title}");
        dataList1.add("{.size}");
        dataList.add(dataList1);
        String fileName = System.currentTimeMillis() + ".xlsx";
        SimpleColumnWidthStyleStrategy simpleColumnWidthStyleStrategy = new SimpleColumnWidthStyleStrategy(30);
        SimpleRowHeightStyleStrategy simpleRowHeightStyleStrategy = new SimpleRowHeightStyleStrategy((short)40, (short)30);
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        File file = new File("D:\\test\\" + fileName);
        InputStream inputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ExcelWriterSheetBuilder sheet = EasyExcel.write(fileOutputStream).sheet();
            sheet.registerWriteHandler(horizontalCellStyleStrategy).registerWriteHandler(simpleColumnWidthStyleStrategy).registerWriteHandler(simpleRowHeightStyleStrategy).head(head).doWrite(dataList);
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("projectName", "projectName");
            map.put("title", "title");
            map.put("size", "size");
            list.add(map);
        }
        try {
            String outFileName = System.currentTimeMillis() + ".xlsx";
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\test\\" + outFileName);
            ExcelWriter excelWriter = EasyExcel.write(fileOutputStream).withTemplate(inputStream).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.FALSE).build();
            excelWriter.fill(list, fillConfig, writeSheet);
            excelWriter.finish();
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 无模板无实体直接写入
     */
    @Test
    public void test2() {
//        String pathName = new String((PATH_NAME + "无模板无实体直接写入" + EXCEL_FORMAT).getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        String pathName = PATH_NAME + "无模板无实体直接写入" + EXCEL_FORMAT;
        List<List<String>> head = new ArrayList<>();
        List<String> head0 = new ArrayList<>();
        head0.add("序号");
        head.add(head0);
        List<String> head1 = new ArrayList<>();
        head1.add("姓名");
        head.add(head1);
        List<String> head2 = new ArrayList<>();
        head2.add("出生日期");
        head.add(head2);
        List<String> head3 = new ArrayList<>();
        head3.add("薪水");
        head.add(head3);
        long now = System.currentTimeMillis();
        List<List<Object>> content = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> list = new ArrayList<>();
            list.add(0);
            list.add("代号" + i);
            list.add(new Date(now + i * 24 * 60 * 60 * 1000));
            list.add((i + 1) * 1111.11);
            content.add(list);
        }
        // 格式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 自动换行
        headWriteCellStyle.setWrapped(Boolean.TRUE);
        /**
         * 字体等样式
         */
        WriteFont headWriteFont = new WriteFont();
        // 字体
        headWriteFont.setFontName("微软雅黑");
        // 加粗
        headWriteFont.setBold(Boolean.TRUE);
        // 字体颜色
        headWriteFont.setColor(IndexedColors.BLUE.index);
        // 设置字体大小
        headWriteFont.setFontHeightInPoints((short) 10);
        // 设置斜体
        headWriteFont.setItalic(Boolean.TRUE);
        // 设置删除线
        headWriteFont.setStrikeout(Boolean.TRUE);
        // 设置下划线
        headWriteFont.setUnderline((byte) 1);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 设置水平方向位置
        headWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 设置垂直方向位置
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        // 设置边框, 设置边框颜色(未列出)
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, new ArrayList<>());
        // 自适应列宽
//        LongestMatchColumnWidthStyleStrategy strategy = new LongestMatchColumnWidthStyleStrategy();
        SimpleColumnWidthStyleStrategy simpleColumnWidthStyleStrategy = new SimpleColumnWidthStyleStrategy(60);
        SimpleRowHeightStyleStrategy simpleRowHeightStyleStrategy = new SimpleRowHeightStyleStrategy((short) 180, (short)60);
//        ChangeCellFontHandler abstractCellWriteHandler = new ChangeCellFontHandler();
        ChangeHeightAndWidthHandler handler = new ChangeHeightAndWidthHandler();
        EasyExcel
                .write(pathName)
                .sheet(0)
//                .registerWriteHandler(strategy)
//                .registerWriteHandler(simpleColumnWidthStyleStrategy)
//                .registerWriteHandler(simpleRowHeightStyleStrategy)
//                .registerWriteHandler(horizontalCellStyleStrategy)
//                .registerWriteHandler(abstractCellWriteHandler)
                .registerWriteHandler(handler)
                .head(head)
                .doWrite(content);
    }

    @Test
    public void test3() {
        // 读取 excel 表格的路径
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        String readPath = "D:\\test\\test1.xlsx";
        File file = new File(readPath);
        List<List<String>> result = new ArrayList<>();
        StringExcelListener listener = new StringExcelListener();
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcelFactory.read(new FileInputStream(file), null, listener).headRowNumber(0).build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        excelReader.read();
        List<List<String>> datas = listener.getDatas();
//        System.out.println(datas.size());
//        System.out.println(datas);
        int temp = 92;
        StringBuilder sb = new StringBuilder("INSERT INTO yuecheng_fire_emergency_track values");
        for (List<String> data : datas) {
            String latitude = data.get(0);
            String longitude = data.get(1);
            String s = data.get(2);
            String time = LocalDateTime.parse(s, dtf1).format(dtf2);
            sb.append("(");
            sb.append(String.format("'%s'", ++temp)).append(",").append("'1'").append(",").append("'2'").append(",").append(String.format("'%s'", time)).append(",").append(latitude).append(",").append(longitude);
            sb.append("),");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(1, 5, 3);
        System.out.println(list.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList()));
    }

    @Test
    public void test5() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    @Test
    public void test6() {
        // 读取 excel 表格的路径
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        String readPath = "D:\\test\\test2.xls";
        File file = new File(readPath);
        List<List<String>> result = new ArrayList<>();
        StringExcelListener listener = new StringExcelListener();
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcelFactory.read(new FileInputStream(file), null, listener).headRowNumber(1).build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        excelReader.read();
        List<List<String>> datas = listener.getDatas();
//        System.out.println(datas.size());
//        System.out.println(datas);
//        datas.forEach(System.out::println);
        StringBuilder sb = new StringBuilder("INSERT INTO yuecheng_fire_emergency_strength values");
        for (List<String> data : datas) {
            String id = data.get(0);
            String region = data.get(1);
            String name = data.get(2);
            String address = data.get(3);
            int houseNumber = Integer.parseInt(data.get(4));
            int floor = Integer.parseInt(data.get(5));
            String tenement = data.get(6);
            String responsible = data.get(7);
            String phone = data.get(8);
            String elevatorCount = data.get(9);
            String maintenanceUnit = data.get(10);
            String longitudeStr = data.get(11);
            String latitudeStr = data.get(12);
            double longitude = 0;
            double latitude = 0;
            if (StringUtils.isNotBlank(longitudeStr)) {
                longitude = Double.parseDouble(longitudeStr);
            }
            if (StringUtils.isNotBlank(latitudeStr)) {
                latitude = Double.parseDouble(latitudeStr);
            }
            sb.append("(").append(String.format("'%s'", id));
            if (StringUtils.isEmpty(name)) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(String.format("'%s'", name));
            }
            if (StringUtils.isEmpty(address)) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(String.format("'%s'", address));
            }
            if (StringUtils.isEmpty(tenement)) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(String.format("'%s'", tenement));
            }
            if (StringUtils.isEmpty(responsible)) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(String.format("'%s'", responsible));
            }
            sb.append(",").append(houseNumber);
            sb.append(",").append(floor);
            if (StringUtils.isEmpty(phone)) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(String.format("'%s'", phone));
            }
            if (longitude == 0) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(longitude);
            }
            if (latitude == 0) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(latitude);
            }
            sb.append(",").append("NULL");
            if (StringUtils.isEmpty(region)) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(String.format("'%s'", region));
            }
            sb.append(",").append(elevatorCount);
            if (StringUtils.isEmpty(maintenanceUnit)) {
                sb.append(",").append("NULL");
            } else {
                sb.append(",").append(String.format("'%s'", maintenanceUnit));
            }
            sb.append("),");
        }
        System.out.println(sb.toString());
    }

}
