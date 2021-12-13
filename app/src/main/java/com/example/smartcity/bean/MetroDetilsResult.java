package com.example.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class MetroDetilsResult implements Serializable {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"id":1,"name":"16号线","first":"西苑","end":"北安河","startTime":"05:25","endTime":"23:00","cityId":1,"stationsNumber":null,"km":40,"runStationsName":"永丰南","metroStepList":[{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":1,"name":"西苑","seq":0,"lineId":1,"firstCh":"X"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":2,"name":"农大南路","seq":0,"lineId":1,"firstCh":"N"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":3,"name":"马连洼","seq":0,"lineId":1,"firstCh":"M"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":4,"name":"西北旺","seq":0,"lineId":1,"firstCh":"X"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":5,"name":"永丰南","seq":0,"lineId":1,"firstCh":"Y"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":6,"name":"永丰","seq":0,"lineId":1,"firstCh":"Y"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":7,"name":"屯佃","seq":0,"lineId":1,"firstCh":"T"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:39","remark":null,"params":{},"id":8,"name":"稻香湖路","seq":0,"lineId":1,"firstCh":"D"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:39","remark":null,"params":{},"id":9,"name":"温阳路","seq":0,"lineId":1,"firstCh":"W"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:39","remark":null,"params":{},"id":10,"name":"北安河","seq":0,"lineId":1,"firstCh":"B"}],"remainingTime":8}
     */

    private String msg;
    private int code;
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public static class DataBean implements Serializable {
        public int getKm() {
            return km;
        }

        public Object getStationsNumber() {
            return stationsNumber;
        }

        public int getRemainingTime() {
            return remainingTime;
        }

        public List<MetroStepListBean> getMetroStepList() {
            return metroStepList;
        }

        public String getRunStationsName() {
            return runStationsName;
        }

        public String getFirst() {
            return first;
        }

        public String getEnd() {
            return end;
        }

        /**
         * id : 1
         * name : 16号线
         * first : 西苑
         * end : 北安河
         * startTime : 05:25
         * endTime : 23:00
         * cityId : 1
         * stationsNumber : null
         * km : 40
         * runStationsName : 永丰南
         * metroStepList : [{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":1,"name":"西苑","seq":0,"lineId":1,"firstCh":"X"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":2,"name":"农大南路","seq":0,"lineId":1,"firstCh":"N"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":3,"name":"马连洼","seq":0,"lineId":1,"firstCh":"M"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":4,"name":"西北旺","seq":0,"lineId":1,"firstCh":"X"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":5,"name":"永丰南","seq":0,"lineId":1,"firstCh":"Y"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":6,"name":"永丰","seq":0,"lineId":1,"firstCh":"Y"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:38","remark":null,"params":{},"id":7,"name":"屯佃","seq":0,"lineId":1,"firstCh":"T"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:39","remark":null,"params":{},"id":8,"name":"稻香湖路","seq":0,"lineId":1,"firstCh":"D"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:39","remark":null,"params":{},"id":9,"name":"温阳路","seq":0,"lineId":1,"firstCh":"W"},{"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:28:36","updateBy":null,"updateTime":"2021-04-05 15:46:39","remark":null,"params":{},"id":10,"name":"北安河","seq":0,"lineId":1,"firstCh":"B"}]
         * remainingTime : 8
         */

        private int id;
        private String name;
        private String first;
        private String end;
        private String startTime;
        private String endTime;
        private int cityId;
        private Object stationsNumber;
        private int km;
        private String runStationsName;
        private int remainingTime;
        private List<MetroStepListBean> metroStepList;

        public static class MetroStepListBean implements Serializable {
            public int getLineId() {
                return lineId;
            }

            public String getName() {
                return name;
            }

            public int getSeq() {
                return seq;
            }

            /**
             * searchValue : null
             * createBy : null
             * createTime : 2018-07-23 02:28:36
             * updateBy : null
             * updateTime : 2021-04-05 15:46:38
             * remark : null
             * params : {}
             * id : 1
             * name : 西苑
             * seq : 0
             * lineId : 1
             * firstCh : X
             */

            private Object searchValue;
            private Object createBy;
            private String createTime;
            private Object updateBy;
            private String updateTime;
            private Object remark;
            private ParamsBean params;
            private int id;
            private String name;
            private int seq;
            private int lineId;
            private String firstCh;

            public static class ParamsBean implements Serializable {
            }
        }
    }
}
