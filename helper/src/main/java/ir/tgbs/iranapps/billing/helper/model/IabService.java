package ir.tgbs.iranapps.billing.helper.model;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

import com.android.vending.billing.IInAppBillingService;

import ir.tgbs.iranapps.billing.IranAppsIabService;

/**
 * Created by Khaled Bakhtiari on 2/15/2015.
 * <a href="http://about.me/kh.bakhtiari">
 */
public class IabService {
    private IInterface service;
    private AppStore appStore;

    public IabService(AppStore appStore, IBinder binder) {
        switch (appStore) {
            case IRANAPPS:
                this.service = IranAppsIabService.Stub.asInterface(binder);
                break;

            case CAFEBAZAAR:
            case GOOGLE_PLAY:
                this.service = IInAppBillingService.Stub.asInterface(binder);
                break;
        }
        this.appStore = appStore;
    }

    public int isBillingSupported(int apiVersion, String packageName, String type) throws RemoteException {
        switch (appStore) {
            case IRANAPPS:
                return ((IranAppsIabService) service).isBillingSupported(apiVersion, packageName, type);

            case CAFEBAZAAR:
            case GOOGLE_PLAY:
                return ((IInAppBillingService) service).isBillingSupported(apiVersion, packageName, type);

            default:
                throw new AppStore.NoSuchAppStoreException(appStore);
        }
    }

    public Bundle getSkuDetails(int apiVersion, String packageName, String type, Bundle skusBundle) throws RemoteException {
        switch (appStore) {
            case IRANAPPS:
                return ((IranAppsIabService) service).getSkuDetails(apiVersion, packageName, type, skusBundle);

            case CAFEBAZAAR:
            case GOOGLE_PLAY:
                return ((IInAppBillingService) service).getSkuDetails(apiVersion, packageName, type, skusBundle);

            default:
                throw new AppStore.NoSuchAppStoreException(appStore);
        }
    }

    public Bundle getBuyIntent(int apiVersion, String packageName, String sku, String type, String developerPayload) throws RemoteException {
        switch (appStore) {
            case IRANAPPS:
                return ((IranAppsIabService) service).getBuyIntent(apiVersion, packageName, sku, type, developerPayload);

            case CAFEBAZAAR:
            case GOOGLE_PLAY:
                return ((IInAppBillingService) service).getBuyIntent(apiVersion, packageName, sku, type, developerPayload);

            default:
                throw new AppStore.NoSuchAppStoreException(appStore);
        }
    }

    public Bundle getPurchases(int apiVersion, String packageName, String type, String continuationToken) throws RemoteException {
        switch (appStore) {
            case IRANAPPS:
                return ((IranAppsIabService) service).getPurchases(apiVersion, packageName, type, continuationToken);

            case CAFEBAZAAR:
            case GOOGLE_PLAY:
                return ((IInAppBillingService) service).getPurchases(apiVersion, packageName, type, continuationToken);

            default:
                throw new AppStore.NoSuchAppStoreException(appStore);
        }
    }

    public int consumePurchase(int apiVersion, String packageName, String purchaseToken) throws RemoteException {
        switch (appStore) {
            case IRANAPPS:
                return ((IranAppsIabService) service).consumePurchase(apiVersion, packageName, purchaseToken);

            case CAFEBAZAAR:
            case GOOGLE_PLAY:
                return ((IInAppBillingService) service).consumePurchase(apiVersion, packageName, purchaseToken);

            default:
                throw new AppStore.NoSuchAppStoreException(appStore);
        }
    }

    public Bundle getLoginIntent(int apiVersion, String packageName) throws RemoteException {
        switch (appStore) {
            case IRANAPPS:
                return ((IranAppsIabService) service).getLoginIntent(apiVersion, packageName);

//            case CAFEBAZAAR:
//                return ((IInAppBillingService) service).consumePurchase(apiVersion, packageName, purchaseToken);

            default:
                throw new AppStore.NoSuchAppStoreException(appStore);
        }
    }

}
