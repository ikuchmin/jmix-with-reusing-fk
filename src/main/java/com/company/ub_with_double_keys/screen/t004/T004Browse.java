package com.company.ub_with_double_keys.screen.t004;

import io.jmix.ui.screen.*;
import com.company.ub_with_double_keys.entity.T004;

@UiController("T004.browse")
@UiDescriptor("t004-browse.xml")
@LookupComponent("t004sTable")
public class T004Browse extends StandardLookup<T004> {
}