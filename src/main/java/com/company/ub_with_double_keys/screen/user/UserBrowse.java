package com.company.ub_with_double_keys.screen.user;

import com.company.ub_with_double_keys.entity.User;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;

@UiController("User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {
}