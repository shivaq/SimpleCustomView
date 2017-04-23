package yasuaki.kyoto.com.simplecustomview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import yasuaki.kyoto.com.simplecustomview.R;


public class CharacterFrameView extends FrameLayout {

  private Drawable characterCircle;
  private Drawable characterBody;
  private Drawable characterMouse;
  private Drawable characterEye;

  private ImageView characterCircleImg;
  private ImageView characterBodyImg;
  private ImageView characterMouseImg;
  private ImageView characterEyeImg;

  public CharacterFrameView(@NonNull Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    LayoutInflater.from(context).inflate(R.layout.character_frame_view, this, true);

    TypedArray typedArray =
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.CharacterFrameView, 0, 0);

    try{
      characterCircle = typedArray.getDrawable(R.styleable.CharacterFrameView_character_circle);
      characterBody = typedArray.getDrawable(R.styleable.CharacterFrameView_character_body);
      characterMouse = typedArray.getDrawable(R.styleable.CharacterFrameView_character_mouse);
      characterEye = typedArray.getDrawable(R.styleable.CharacterFrameView_character_eye);
    } finally{
      typedArray.recycle();
    }

    // Throw an exception if required attributes are not set
    if (characterCircle == null) {
      throw new RuntimeException("No characterCircle provided");
    }
    if (characterBody == null) {
      throw new RuntimeException("No characterBody provided");
    }
    if (characterMouse == null) {
      throw new RuntimeException("No characterMouse provided");
    }
    if (characterEye == null) {
      throw new RuntimeException("No characterEye provided");
    }
    init(characterCircle, characterBody, characterMouse, characterEye);
  }

  // Setup Views
  private void init(Drawable characterCircle, Drawable characterBody, Drawable characterMouse, Drawable characterEye) {
    characterCircleImg = (ImageView) findViewById(R.id.subject_circles);
    characterBodyImg = (ImageView) findViewById(R.id.subject_body);
    characterMouseImg = (ImageView) findViewById(R.id.subject_mouse);
    characterEyeImg = (ImageView) findViewById(R.id.subject_eye);

    characterCircleImg.setImageDrawable(characterCircle);
    characterBodyImg.setImageDrawable(characterBody);
    characterMouseImg.setImageDrawable(characterMouse);
    characterEyeImg.setImageDrawable(characterEye);
  }

  public void setCharacterCircleImg(int drawableId) {
    characterCircleImg.setImageResource(drawableId);
  }
  public void setCharacterBodyImg(int drawableId) {
    characterBodyImg.setImageResource(drawableId);
  }
  public void setCharacterMouseImg(int drawableId) {
    characterMouseImg.setImageResource(drawableId);
  }
  public void setCharacterEyeImg(int drawableId) {
    characterEyeImg.setImageResource(drawableId);
  }
}