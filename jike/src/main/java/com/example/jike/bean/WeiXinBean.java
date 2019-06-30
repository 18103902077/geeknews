package com.example.jike.bean;

import java.util.List;

public class WeiXinBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2019-06-29","title":"当收到多个offer的时候，我们应该如何抉择？","description":"留学英国","picUrl":"http:=1561771812&amp;ver=1697&amp;signature=OihXosIyE5lazdrOBA3W3KX7UR8PiWDc2Bzl1BrS8ojj904h9t5Kn0y3n7ae5y81O*ozffn63L-sQbRBSCug0szelz99KX-cAakevuSL9reU720XqY71r-xxTUo5OMAB&amp;new=1"},{"ctime":"2019-06-29","title":"这个菜拌面又香又入味，一口气能吃两大碗！","description":"茹素人生","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/sohfrwwRWRNH96dvichT39J4OxCG6wke3I3BRa1q2XMaPL4gVs3MIfF0IIwcdntZpJqA4upjibp8ichtYo0KDNayw/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1561771811&amp;ver=1697&amp;signature=wxXL9ZNO*hRvCWHm*9ChfLU*a7FO7u4KrRneGa*GeFOGO3y2t27ChqToBuK7zoI8EtCVb2L1b1ZUVG6BlCnSvbbo*3GXM*u*hxiyhoLx5DKPDBTcfazchK06LIBbL8WQ&amp;new=1"},{"ctime":"2019-06-29","title":"胆小慎入! 隆胸、摘眼球、开头颅...让你目瞪口呆的手术动图","description":"医者部落","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/ibuwkic338huccZDHkPd4a842tsNzfeWJDZQUoqaNCGxOMOWYTtVht0fsYob56Hl2BO4zHMWoDLEgPFUnyVxahnA/0?wx_fmt=jpeg","url":"https://mp.weixin.qq.com/s?src=11&amp;timestamp=1561771801&amp;ver=1697&amp;signature=XXnWEuUliKwYuLtOXrgJMkv0BP2oMIgsjErM9V5ShzzdgfaHGVa*C*sQpyEakgnyY--wV1CBD64TE5ihTozodbJNUd0orcmGaTlLFgaC08P0XaOhvN0nAulZqhYjM4ay&amp;new=1"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2019-06-29
         * title : 当收到多个offer的时候，我们应该如何抉择？
         * description : 留学英国
         * picUrl : http:=1561771812&amp;ver=1697&amp;signature=OihXosIyE5lazdrOBA3W3KX7UR8PiWDc2Bzl1BrS8ojj904h9t5Kn0y3n7ae5y81O*ozffn63L-sQbRBSCug0szelz99KX-cAakevuSL9reU720XqY71r-xxTUo5OMAB&amp;new=1
         * url : https://mp.weixin.qq.com/s?src=11&amp;timestamp=1561771811&amp;ver=1697&amp;signature=wxXL9ZNO*hRvCWHm*9ChfLU*a7FO7u4KrRneGa*GeFOGO3y2t27ChqToBuK7zoI8EtCVb2L1b1ZUVG6BlCnSvbbo*3GXM*u*hxiyhoLx5DKPDBTcfazchK06LIBbL8WQ&amp;new=1
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
