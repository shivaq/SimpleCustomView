package yasuaki.kyoto.com.simplecustomview.ui;

public interface MvpPresenter<V extends MvpView> {

    void onAttachView(V mvpView);

    void onDetachView();
}
