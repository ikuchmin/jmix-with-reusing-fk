package com.company.ub_with_double_keys.screen.ctable;

import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.screen.*;
import com.company.ub_with_double_keys.entity.CTable;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("CTable.browse")
@UiDescriptor("c-table-browse.xml")
@LookupComponent("cTablesTable")
public class CTableBrowse extends StandardLookup<CTable> {
    @Autowired
    private Notifications notifications;

    @Autowired
    private GroupTable<CTable> cTablesTable;

    @Subscribe("testBtn")
    public void onTestBtnClick(Button.ClickEvent event) {

        var singleSelected = cTablesTable.getSingleSelected();

//        notifications.create(Notifications.NotificationType.HUMANIZED)
//                .withCaption(singleSelected.getSaknr().getId().getSaknr()).

    }
}