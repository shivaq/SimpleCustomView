package yasuaki.kyoto.com.simplecustomview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import yasuaki.kyoto.com.simplecustomview.R;

public class CustomView extends LinearLayout {

  public CustomView(Context context,
      @Nullable AttributeSet attrs) {
    super(context, attrs);
    setOrientation(LinearLayout.VERTICAL);
    LayoutInflater.from(context).inflate(R.layout.custom_view, this, true);

    String title;
    String subtitle;
    TypedArray typedArray =
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, 0, 0);

    try{
      title = typedArray.getString(R.styleable.CustomView_custom_view_title);
      subtitle = typedArray.getString(R.styleable.CustomView_custom_view_subtitle);
    } finally{
      typedArray.recycle();
    }

    // Throw an exception if required attributes are not set
    if (title == null) {
      throw new RuntimeException("No title provided");
    }
    if (subtitle == null) {
      throw new RuntimeException("No subtitle provided");
    }
    init(title, subtitle);
  }

  // Setup Views
  private void init(String title, String subtitle){
    TextView titleView = (TextView) findViewById(R.id.customview_textview_title);
    TextView subtitleView = (TextView) findViewById(R.id.customview_textview_subtitle);
    titleView.setText(title);
    subtitleView.setText(subtitle);
  }
}
