package yasuaki.kyoto.com.simplecustomview.ui;

import javax.inject.Inject;

import timber.log.Timber;
import yasuaki.kyoto.com.simplecustomview.data.DataManager;

public class MainPresenter<V extends MvpView> implements MvpPresenter<V> {

    private DataManager mDataManager;
    private V mMvpView;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void onAttachView(V mvpView) {
        mMvpView = mvpView;
        Timber.d("MainPresenter:onAttachView: mMvpView is %s", mMvpView);
    }

    @Override
    public void onDetachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }
}
