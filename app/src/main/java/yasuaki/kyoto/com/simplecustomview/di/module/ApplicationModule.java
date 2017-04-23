package yasuaki.kyoto.com.simplecustomview.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import yasuaki.kyoto.com.simplecustomview.di.ApplicationContext;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

//    @Provides
//    @Singleton
//    DataManager provideDataManager(AppDataManager appDataManager) {
//        return appDataManager;
//    }

}
