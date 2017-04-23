package yasuaki.kyoto.com.simplecustomview.utility;

import yasuaki.kyoto.com.simplecustomview.R;

/**
 * Created by Yasuaki on 2017/04/23.
 */

public class Utility {

  static int[] colorList = {R.color.red_30a, R.color.amber_50, R.color.cyan_90a};

  public static int getRandomColorInt() {
    int randomInt = (int) (Math.random() * 3);
    return colorList[randomInt];
  }
}
