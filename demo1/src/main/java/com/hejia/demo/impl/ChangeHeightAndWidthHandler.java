package com.hejia.demo.impl;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.style.column.AbstractColumnWidthStyleStrategy;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * @date 2020/12/16
 * @author hj
 * desc 改变单元格宽度的拦截器, 这种可以直接用继承AbstractCellWriteHandler去实现, 当前这种实现方式并不太友好, 不建议使用
 */

public class ChangeHeightAndWidthHandler extends AbstractColumnWidthStyleStrategy {
    @Override
    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<CellData> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        // 如果单元格是String类型的, 改变其宽度
        Sheet sheet = writeSheetHolder.getSheet();
        CellType cellTypeEnum = cell.getCellTypeEnum();
        if (cellTypeEnum == CellType.STRING) {
            sheet.setColumnWidth(cell.getColumnIndex(), 3000);
        }
    }
}
