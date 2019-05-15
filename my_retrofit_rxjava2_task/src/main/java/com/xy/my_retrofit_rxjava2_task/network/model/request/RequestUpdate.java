package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.account.AccountDataHelper;
import com.okay.teachertasklib.flux.store.ApplicationStore;
import com.okay.teachertasklib.network.model.base.RequestBase;
import com.okay.teachertasklib.utils.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestUpdate extends RequestBase {
    public RequestUpdate() {
        sidlist = new ArrayList<>();
        apps = new ArrayList<>();
        sidlist.add(AccountDataHelper.loadOrgid(ApplicationStore.get().getApplicationContext()));
        apps.add(new Update());
    }

    public int tab = 1;
    public List<Update> apps;
    public List<String> sidlist;

    public class Update {
        public String pkgname = Device.getPackageName();
        public int vcode = Device.getVersionCode();
    }

}
