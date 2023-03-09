package com.hejia.demo.impl;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.AbstractCellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.AbstractVerticalCellStyleStrategy;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @date 2020/12/16
 * @author hj
 * desc 改变单元格样式的拦截器
 */

public class ChangeCellFontHandler extends AbstractCellWriteHandler {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static String EMPTY = "";

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        CellType cellTypeEnum = cell.getCellTypeEnum();
        String value;
        switch (cellTypeEnum) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = sdf.format(cell.getDateCellValue());
                } else {
                    value = String.valueOf(cell.getNumericCellValue());
                }
                break;
            default:
                value = EMPTY;
                break;
        }
        // 如果是代号1, 改变该单元格样式
        if (StringUtils.equals(value, "代号1")) {
            Sheet sheet = writeSheetHolder.getSheet();
            Workbook workbook = sheet.getWorkbook();
            CellStyle cellStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setColor(IndexedColors.RED.index);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
        }
    }
}
