package com.xpp.neo1.paperplane.bean;

import java.util.List;

/**
 * Created by neo1 on 2017/2/17.
 */

public class ZhihuNews {

    /**
     * date : 20170217
     * stories : [{"images":["http://pic2.zhimg.com/4a35928c7c400d086bbbd9c8fe6f74d5.jpg"],"type":0,"id":9229883,"ga_prefix":"021716","title":"中国特色苹果「助手」正侵蚀 iOS 35% 收入"},{"images":["http://pic2.zhimg.com/cb347835e7c25588524854178544fbb9.jpg"],"type":0,"id":9195350,"ga_prefix":"021715","title":"爱情也有保质期，你们的关系进入倦怠期了吗？"},{"images":["http://pic2.zhimg.com/2e82cc6a9454d7c00dd72d5baa02c991.jpg"],"type":0,"id":9229819,"ga_prefix":"021715","title":"身为化妆品研发，告诉你高档产品与平价产品的差别在哪里"},{"images":["http://pic4.zhimg.com/a9a1d6382a7523faeab57caa88e4adb7.jpg"],"type":0,"id":9229286,"ga_prefix":"021713","title":"杨永信的「电疗法」和临床电刺激有什么区别？"},{"images":["http://pic2.zhimg.com/00d6ad3c7a150cba665981dd605612c1.jpg"],"type":0,"id":9229153,"ga_prefix":"021712","title":"大误 · 粉红色的回忆"},{"images":["http://pic2.zhimg.com/285e3712dbc4b82d0e3204a8c7d92331.jpg"],"type":0,"id":9229241,"ga_prefix":"021711","title":"看过这两张图，就明白电脑里的「缓存」是什么意思"},{"title":"地图上的各种等高线，是怎么画出来的？","ga_prefix":"021710","images":["http://pic4.zhimg.com/d33c5f909bdaa89a7ee7ddef1269d58b.jpg"],"multipic":true,"type":0,"id":9228981},{"images":["http://pic2.zhimg.com/44dfd68dead91180bea733ede5b03a59.jpg"],"type":0,"id":9222067,"ga_prefix":"021709","title":"你能分清汉堡和三明治吗？想一下再回答"},{"title":"跑车的声浪，可远不止换个排气管，拆掉消声器那么简单","ga_prefix":"021708","images":["http://pic1.zhimg.com/2d1e8bfffc13cbf09c965f7f2960569c.jpg"],"multipic":true,"type":0,"id":9227351},{"images":["http://pic3.zhimg.com/78021164c388c73a81d9a2165b04adaa.jpg"],"type":0,"id":9228136,"ga_prefix":"021707","title":"年轻白领挣得不如蓝领多，因为还没拿到「职位工资」"},{"images":["http://pic4.zhimg.com/a6dcb81766cfcb1508946a0a77379c27.jpg"],"type":0,"id":9224698,"ga_prefix":"021707","title":"不，不要以为洗脸刷的意义在于把脸洗得更干净"},{"images":["http://pic1.zhimg.com/942ff2a7eccedd4fa9bae14bb06bae18.jpg"],"type":0,"id":9228345,"ga_prefix":"021707","title":"为何没多少人买，星巴克还在卖依云？"},{"images":["http://pic4.zhimg.com/89a3a8062235b2e9e528ab7e5589b6e3.jpg"],"type":0,"id":9221954,"ga_prefix":"021706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/9eec7afd151dfd34b058beddfb91b983.jpg","type":0,"id":9229286,"ga_prefix":"021713","title":"杨永信的「电疗法」和临床电刺激有什么区别？"},{"image":"http://pic4.zhimg.com/954e6cd415d0bb4827acb5b0004c666b.jpg","type":0,"id":9224698,"ga_prefix":"021707","title":"不，不要以为洗脸刷的意义在于把脸洗得更干净"},{"image":"http://pic4.zhimg.com/c5d0a7961254a074c2d399bc93b60ae3.jpg","type":0,"id":9228345,"ga_prefix":"021707","title":"为何没多少人买，星巴克还在卖依云？"},{"image":"http://pic1.zhimg.com/1b82783638a0e45a9af5ab24b5b8b374.jpg","type":0,"id":9226599,"ga_prefix":"021613","title":"市值超过 Twitter，微博抓住了年轻人、娱乐化和更多玩法"},{"image":"http://pic4.zhimg.com/57a7e6970a757ea744a6545135ed953f.jpg","type":0,"id":9226579,"ga_prefix":"021612","title":"《职人介绍所》第二季第五期：超级帅的拳击教练，并不是要教你们怎么打架"}]
     */

    private String date;
    /**
     * images : ["http://pic2.zhimg.com/4a35928c7c400d086bbbd9c8fe6f74d5.jpg"]
     * type : 0
     * id : 9229883
     * ga_prefix : 021716
     * title : 中国特色苹果「助手」正侵蚀 iOS 35% 收入
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic4.zhimg.com/9eec7afd151dfd34b058beddfb91b983.jpg
     * type : 0
     * id : 9229286
     * ga_prefix : 021713
     * title : 杨永信的「电疗法」和临床电刺激有什么区别？
     */

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
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

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

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
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
