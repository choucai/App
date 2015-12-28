package com.dream.java.think.think11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by William on 15/11/18.
 */
public class AsListInference {

    static class Snow {
    }

    static class Powder extends Snow {
    }

    static class Crusty extends Snow {
    }

    static class Slush extends Snow {
    }

    static class Light extends Powder {
    }

    static class Heavy extends Powder {
    }


    public static void main(String[] args) {

        List<Snow> snow1 = Arrays.asList(new Powder(), new Crusty(), new Slush());
//        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());


        // Collections.addAll() doesn't get confused
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,new Light(), new Heavy());

        // Give a hint using an explicit type argument specifiction:
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());

    }

}
