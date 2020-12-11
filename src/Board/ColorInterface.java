package Board;

import java.util.ArrayList;
import java.util.Arrays;

public interface ColorInterface {

    boolean Dark = false;
    boolean Light = true;


    static String getColorFromBool(boolean boolColor) {

        int color = (boolColor)?1:0;
        ArrayList colorList = new ArrayList();
        colorList.addAll(Arrays.asList("Dark", "Light"));
        return colorList.get(color).toString();
    }
}
