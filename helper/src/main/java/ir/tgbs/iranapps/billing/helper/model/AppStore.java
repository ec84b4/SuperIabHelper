package ir.tgbs.iranapps.billing.helper.model;

import static ir.tgbs.iranapps.billing.helper.util.InAppKeys.CAFEBAZAAR_PACKAGE_NAME;
import static ir.tgbs.iranapps.billing.helper.util.InAppKeys.CANDO_PACKAGE_NAME;
import static ir.tgbs.iranapps.billing.helper.util.InAppKeys.GOOGLE_PLAY_PACKAGE_NAME;
import static ir.tgbs.iranapps.billing.helper.util.InAppKeys.IRANAPPS_PACKAGE_NAME;
import static ir.tgbs.iranapps.billing.helper.util.InAppKeys.MYKET_PACKAGE_NAME;
import static ir.tgbs.iranapps.billing.helper.util.InAppKeys.PARSHUB_PACKAGE_NAME;

/**
 * Created by Khaled Bakhtiari on 2/15/2015.
 * <a href="http://about.me/kh.bakhtiari">
 */
public enum AppStore {
    IRANAPPS(IRANAPPS_PACKAGE_NAME, "ir.tgbs.iranapps.billing.IranAppsIabService"),
    CAFEBAZAAR(CAFEBAZAAR_PACKAGE_NAME, "ir.cafebazaar.pardakht.InAppBillingService.BIND"),
    GOOGLE_PLAY(GOOGLE_PLAY_PACKAGE_NAME, "com.android.vending.billing.InAppBillingService.BIND"),
    CANDO(CANDO_PACKAGE_NAME, "com.ada.market.service.payment.BIND"),
    MYKET(MYKET_PACKAGE_NAME, "ir.mservices.market.InAppBillingService.BIND"),
    PARSHUB(PARSHUB_PACKAGE_NAME, "net.jhoobin.jhub.InAppBillingService.BIND");

    public String packageName;
    public String intentAction;

    AppStore(String packageName, String intentAction) {
        this.packageName = packageName;
        this.intentAction = intentAction;
    }

    public static class NoSuchAppStoreException extends RuntimeException {
        public NoSuchAppStoreException(AppStore appStore) {
            super("this appStore: '" + appStore.name() + "' doesn't exist.");
        }
    }
}