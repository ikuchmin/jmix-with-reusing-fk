package com.company.ub_with_double_keys.screen.ctable;

import io.jmix.ui.screen.*;
import com.company.ub_with_double_keys.entity.CTable;

@UiController("CTable.edit")
@UiDescriptor("c-table-edit.xml")
@EditedEntityContainer("cTableDc")
public class CTableEdit extends StandardEditor<CTable> {
}