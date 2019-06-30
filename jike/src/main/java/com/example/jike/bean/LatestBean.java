package com.example.jike.bean;

import java.util.List;

public class LatestBean {

    /**
     * date : 20190629
     * stories : [{"title":"男性的腿是不是比女性的腿更显细?","ga_prefix":"062909","images":["https://pic2.zhimg.com/v2-3c89aeb2bc1f471b9ac2e1130871f56d.jpg"],"multipic":true,"type":0,"id":9712844},{"images":["https://pic4.zhimg.com/v2-b3406ef6ff6273ff2f183a7887df3b4f.jpg"],"type":0,"id":9712838,"ga_prefix":"062907","title":"北京一半的鱼消失了"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-e931187fac8a95cd2b723bc71c452ec8.jpg","type":0,"id":9712928,"ga_prefix":"062807","title":"想试试 iOS 13？现在就可以尝鲜"},{"image":"https://pic4.zhimg.com/v2-6464e1af5f9da2fd3b3112022b759ed7.jpg","type":0,"id":9712709,"ga_prefix":"062407","title":"我拆了根 Apple Pencil，告诉你它的原理是什么"},{"image":"https://pic2.zhimg.com/v2-9dde01ce46ea2f25e2b3f27248f0ca15.jpg","type":0,"id":9712688,"ga_prefix":"062307","title":"中国电影票房 9 年来首次负增长，是什么原因导致的？"},{"image":"https://pic3.zhimg.com/v2-618ea58f3bcf9491e56701c5890f2bae.jpg","type":0,"id":9712730,"ga_prefix":"062209","title":"私处毛发清洁，该用洗发露还是沐浴露？"},{"image":"https://pic4.zhimg.com/v2-e93a312f674d01e57bca0e0abe897547.jpg","type":0,"id":9712644,"ga_prefix":"061914","title":"自己人的广告 · 终极问题的终极答案"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 男性的腿是不是比女性的腿更显细?
         * ga_prefix : 062909
         * images : ["https://pic2.zhimg.com/v2-3c89aeb2bc1f471b9ac2e1130871f56d.jpg"]
         * multipic : true
         * type : 0
         * id : 9712844
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-e931187fac8a95cd2b723bc71c452ec8.jpg
         * type : 0
         * id : 9712928
         * ga_prefix : 062807
         * title : 想试试 iOS 13？现在就可以尝鲜
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
