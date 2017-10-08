package com.deverdie.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tphon on 6/10/2560.
 */

public class cTables {
    List<cRows> cRowses = new ArrayList<>();

    class cRows {
        List<cColumns> cColumnses = new ArrayList<>();

        public List<cColumns> getcColumnses() {
            return cColumnses;
        }

        public void setcColumnses(List<cColumns> cColumnses) {
            this.cColumnses = cColumnses;
        }
    }

    class cColumns {
        HashMap<String, String> colHashMap = new HashMap<>();

        public HashMap<String, String> getColHashMap() {
            return colHashMap;
        }

        public void setColHashMap(HashMap<String, String> colHashMap) {
            this.colHashMap = colHashMap;
        }
    }


}
