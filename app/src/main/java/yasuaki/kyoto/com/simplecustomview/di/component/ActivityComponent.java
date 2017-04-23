package yasuaki.kyoto.com.simplecustomview.di.component;

import dagger.Component;
import yasuaki.kyoto.com.simplecustomview.di.PerActivity;
import yasuaki.kyoto.com.simplecustomview.di.module.ActivityModule;
import yasuaki.kyoto.com.simplecustomview.ui.MainActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}