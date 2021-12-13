package com.example.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class JobpostResult implements Serializable {


    /**
     * total : 15
     * rows : [{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":1,"companyId":3,"professionId":1,"contacts":"张先生","name":"软件开发","obligation":"负责软件的设计开发测试以及上线","address":"大连市万达广场","need":"工作经验1-2年","salary":"5000","companyName":"虎鱼科技","professionName":"java开发工程师"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":2,"companyId":5,"professionId":5,"contacts":"王女士","name":"医生助理五险一金双休","obligation":"辅助医生参与患者治疗和管理","address":"大连市沙河口区中山路","need":"工作经验1-2年","salary":"5000","companyName":"牙大夫","professionName":"牙医"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":3,"companyId":4,"professionId":2,"contacts":"李先生","name":"平面设计师（包吃住）","obligation":"能够高效的完成平面设计，排版设计，图文海报设计，宣传单名片设计，画册设计，要求具有良好的审美能力，一次成稿率较高，视觉传达专业毕业优先。公司下设设计部，工作职责是：为客户提供设计服务。","address":"大连 - 高新园区 - 黄浦路","need":"工作经验1-2年","salary":"6000","companyName":"恒但科技公司","professionName":"设计"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":4,"companyId":2,"professionId":3,"contacts":"张先生","name":"五险一金+6k英语老师","obligation":"外语教师:一、从事3到12岁少儿英语教学，以游戏活动方式进行英文式授课，授课英语课程对话单词歌曲等，\r\n二、负责将学生的学习情况与家长保持积极的沟通，并给予耐心的指导，三、配合学校定期举办的各项活动，","address":"大连 - 中山 - 迎宾路","need":"工作经验1-2年","salary":"8000","companyName":"左培互联网有限公司","professionName":"外教"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":5,"companyId":6,"professionId":6,"contacts":"陈先生","name":"工程师","obligation":"认真负责","address":"沙河口区","need":"本科及以上学历","salary":"6000","companyName":"大连美俊达铝业有限公司","professionName":"全栈开发工程师"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":6,"companyId":1,"professionId":1,"contacts":"邓先生","name":"前端开发师","obligation":"认真负责，团结。","address":"沙河口区","need":"有2年以上工作经验，研究生以上学位","salary":"10000","companyName":"新型技术公司","professionName":"java开发工程师"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":7,"companyId":7,"professionId":7,"contacts":"吕先生","name":"前台经理","obligation":"诚信友善。","address":"大连沙河口区软件园数码广场数码路100号","need":"55岁以下，有工作经验。","salary":"3000-4000","companyName":"宜客宜家","professionName":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":8,"companyId":8,"professionId":8,"contacts":"周先生","name":"服装模特","obligation":"服装拍摄","address":"沙河口区","need":"男 身材良好 相貌优异 身高178以上 身体裸露部位无明显纹身。","salary":"5000","companyName":"大连视洛文化传媒有限公司","professionName":null},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":9,"companyId":9,"professionId":9,"contacts":"许女士","name":"快递员","obligation":"送快递","address":"甘井子区","need":"身体健康，会骑电瓶车。五十岁以下","salary":"4000","companyName":"大连伊帆货运代理有限公司","professionName":"前台经理"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":10,"companyId":10,"professionId":10,"contacts":"秦女士","name":"按摩师","obligation":"按摩给用户良好体验","address":"旅顺口","need":"女 40岁以下 相貌清秀 会按摩具备学习能力","salary":"3000","companyName":"泰普提","professionName":"服装模特"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":11,"companyId":11,"professionId":11,"contacts":"刘先生","name":"寝室长","obligation":"管理社区卫生，维护舍友关系。保管和整理宿舍用品。","address":"大连高新园区数码路数码大厦","need":"维护寝室社区规定，遵守规章制度。\n长期6个月以上，周休一天。","salary":"面议","companyName":"有家舒舍","professionName":"快递员"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":12,"companyId":12,"professionId":12,"contacts":"陈先生","name":"校园菜鸟驿站工作人员","obligation":"吃苦耐劳，出点体力，把快递放架子上入库发短信，需要人职人员细心认真。会用电脑。","address":"甘井子区","need":"男女不限，负责该店的日常运营","salary":"3200","companyName":"满溢商贸","professionName":"按摩师"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":13,"companyId":13,"professionId":13,"contacts":"程先生","name":"海德堡机长助手","obligation":"1.根据客户需求，提供印刷。\n2.确定符合要求的油墨，纸张等原材料。","address":"营城子","need":"印刷或相关专业专科以上学历，一年以上工作经验。精通印刷工艺及流程。早七点半到晚四点半。有时会倒班。","salary":"3000-4500","companyName":"鑫元印刷","professionName":"寝室长"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":14,"companyId":14,"professionId":14,"contacts":"朱女士","name":"快递员","obligation":null,"address":null,"need":null,"salary":"3000","companyName":"大连飞翔物流有限公司","professionName":"校园菜鸟驿站工作人员"},{"searchValue":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"params":{},"id":15,"companyId":15,"professionId":15,"contacts":"罗先生","name":"快递员","obligation":"送快递","address":"华南国际商城","need":"男 身体健康 有工作经验 熟悉路线。至少工作三个月以上。","salary":"3000","companyName":"久恒经济","professionName":"海德堡机长助手"}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsBean> rows;

    public List<RowsBean> getRows() {
        return rows;
    }

    public static class RowsBean implements Serializable {
        /**
         * searchValue : null
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * params : {}
         * id : 1
         * companyId : 3
         * professionId : 1
         * contacts : 张先生
         * name : 软件开发
         * obligation : 负责软件的设计开发测试以及上线
         * address : 大连市万达广场
         * need : 工作经验1-2年
         * salary : 5000
         * companyName : 虎鱼科技
         * professionName : java开发工程师
         */

        private Object searchValue;
        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private ParamsBean params;
        private int id;
        private int companyId;
        private int professionId;
        private String contacts;
        private String name;
        private String obligation;
        private String address;
        private String need;
        private String salary;
        private String companyName;
        private String professionName;

        public int getId() {
            return id;
        }

        public int getCompanyId() {
            return companyId;
        }

        public int getProfessionId() {
            return professionId;
        }

        public String getContacts() {
            return contacts;
        }

        public String getName() {
            return name;
        }

        public String getObligation() {
            return obligation;
        }

        public String getAddress() {
            return address;
        }

        public String getNeed() {
            return need;
        }

        public String getSalary() {
            return salary;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getProfessionName() {
            return professionName;
        }

        public static class ParamsBean implements Serializable {
        }
    }
}
