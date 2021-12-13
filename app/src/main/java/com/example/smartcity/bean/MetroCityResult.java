package com.example.smartcity.bean;

import java.io.Serializable;


public class MetroCityResult implements Serializable {

    /**
     * msg : 操作成功
     * code : 200
     * data : {"searchValue":null,"createBy":null,"createTime":"2018-07-23 02:15:27","updateBy":null,"updateTime":"2021-05-08 12:34:06","remark":null,"params":{},"id":1,"name":"北京市","code":131,"imgUrl":"/prod-api/profile/upload/image/2021/05/08/554f2392-1e1c-4449-b95c-327a5f7ec91d.jpeg"}
     */

    private String msg;
    private int code;
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public static class DataBean implements Serializable {
        /**
         * searchValue : null
         * createBy : null
         * createTime : 2018-07-23 02:15:27
         * updateBy : null
         * updateTime : 2021-05-08 12:34:06
         * remark : null
         * params : {}
         * id : 1
         * name : 北京市
         * code : 131
         * imgUrl : /prod-api/profile/upload/image/2021/05/08/554f2392-1e1c-4449-b95c-327a5f7ec91d.jpeg
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
        private int code;
        private String imgUrl;

        @Override
        public String toString() {
            return "DataBean{" +
                    "searchValue=" + searchValue +
                    ", createBy=" + createBy +
                    ", createTime='" + createTime + '\'' +
                    ", updateBy=" + updateBy +
                    ", updateTime='" + updateTime + '\'' +
                    ", remark=" + remark +
                    ", params=" + params +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", code=" + code +
                    ", imgUrl='" + imgUrl + '\'' +
                    '}';
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public static class ParamsBean implements Serializable {
        }
    }
}
