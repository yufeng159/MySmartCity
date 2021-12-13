package com.example.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class MetroListResult implements Serializable {


    /**
     * msg : 操作成功
     * code : 200
     * data : [{"lineId":31,"lineName":"2号线",
     * "preStep":{"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},
     * "nextStep":{"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},
     * "currentName":"建国门","reachTime":9},
     * {"lineId":33,"lineName":"1号线","preStep":
     * {"name":"东单","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":34,"lineName":"5号线"},{"lineId":35,"lineName":"1号线"},{"lineId":39,"lineName":"5号线"}]},
     * "nextStep":{"name":"永安里","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":35,"lineName":"1号线"}]},"currentName":"建国门","reachTime":1},{"lineId":35,"lineName":"1号线",
     * "preStep":{"name":"永安里","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":35,"lineName":"1号线"}]},
     * "nextStep":{"name":"东单","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":34,"lineName":"5号线"},{"lineId":35,"lineName":"1号线"},{"lineId":39,"lineName":"5号线"}]},
     * "currentName":"建国门","reachTime":3},
     * {"lineId":38,"lineName":"2号线",
     * "preStep":{"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},
     * "nextStep":{"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},
     * "currentName":"建国门","reachTime":3}]
     */

    private String msg;
    private int code;
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * lineId : 31
         * lineName : 2号线
         * preStep : {"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
         * nextStep : {"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
         * currentName : 建国门
         * reachTime : 9
         */

        private int lineId;
        private String lineName;
        private PreStepBean preStep;
        private NextStepBean nextStep;
        private String currentName;
        private int reachTime;

        public int getLineId() {
            return lineId;
        }

        public void setLineId(int lineId) {
            this.lineId = lineId;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public PreStepBean getPreStep() {
            return preStep;
        }

        public void setPreStep(PreStepBean preStep) {
            this.preStep = preStep;
        }

        public NextStepBean getNextStep() {
            return nextStep;
        }

        public void setNextStep(NextStepBean nextStep) {
            this.nextStep = nextStep;
        }

        public String getCurrentName() {
            return currentName;
        }

        public void setCurrentName(String currentName) {
            this.currentName = currentName;
        }

        public int getReachTime() {
            return reachTime;
        }

        public void setReachTime(int reachTime) {
            this.reachTime = reachTime;
        }
        public static class PreStepBean implements Serializable {
            /**
             * name : 朝阳门
             * lines : [{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
             */

            private String name;
            private List<LinesBean> lines;
            public static class LinesBean implements Serializable {
                /**
                 * lineId : 21
                 * lineName : 6号线
                 */

                private int lineId;
                private String lineName;
            }
        }

        public static class NextStepBean implements Serializable {
            public String getName() {
                return name;
            }

            /**
             * name : 北京站
             * lines : [{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
             */

            private String name;
            private List<LinesBeanX> lines;
            public static class LinesBeanX implements Serializable {
                /**
                 * lineId : 31
                 * lineName : 2号线
                 */

                private int lineId;
                private String lineName;
            }
        }
    }
}
