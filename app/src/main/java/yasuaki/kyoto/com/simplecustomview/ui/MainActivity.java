package yasuaki.kyoto.com.simplecustomview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javax.inject.Inject;
import timber.log.Timber;
import yasuaki.kyoto.com.simplecustomview.MvpApplication;
import yasuaki.kyoto.com.simplecustomview.R;
import yasuaki.kyoto.com.simplecustomview.di.component.ActivityComponent;
import yasuaki.kyoto.com.simplecustomview.di.component.DaggerActivityComponent;
import yasuaki.kyoto.com.simplecustomview.di.module.ActivityModule;
import yasuaki.kyoto.com.simplecustomview.widget.CharacterFrameView;

public class MainActivity extends AppCompatActivity implements MvpView{

    @Inject
    MvpPresenter<MvpView> mPresenter;

  @BindView(R.id.subject_character)CharacterFrameView subjectCharacter;
  @BindView(R.id.textView)
  TextView tv;
  boolean changedToMagician;

    public MainActivity(){}

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApplication) getApplication()).getComponent())
                .build();

        getActivityComponent().inject(this);
        mPresenter.onAttachView(this);

    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

  @OnClick(R.id.subject_character)
  void onSubCharacterClicked(){
    if (changedToMagician) {
      subjectCharacter.setCharacterCircleImg(R.drawable.ic_robot_circle);
      subjectCharacter.setCharacterBodyImg(R.drawable.ic_robot_body);
      subjectCharacter.setCharacterMouseImg(0);
      subjectCharacter.setCharacterEyeImg(0);
      changedToMagician = false;
    } else {
      subjectCharacter.setCharacterCircleImg(R.drawable.ic_magician_circle);
      subjectCharacter.setCharacterBodyImg(R.drawable.ic_magician_body);
      subjectCharacter.setCharacterMouseImg(R.drawable.ic_magician_mouse);
      subjectCharacter.setCharacterEyeImg(R.drawable.ic_magician_eye);
      changedToMagician = true;
    }

  }
  @OnClick(R.id.textView)
  void onTextClicked(){
    tv.setText("さわったね");
    Timber.d("MainActivity:onTextClicked: ");
  }
}
