package com.xpp.neo1.paperplane.bean;

import java.util.List;

/**
 * Created by neo1 on 2017/2/17.
 */

public class ZhihuHistory {

    /**
     * date : 20151231
     * stories : [{"images":["http://pic4.zhimg.com/85f9acd1e6a6855a8c18a686a6a9e58b.jpg"],"type":0,"id":7571431,"ga_prefix":"123122","title":"深夜惊奇 · 性格大变"},{"images":["http://pic4.zhimg.com/4203d3e2d017ccbd02020817188f4663.jpg"],"type":0,"id":7681620,"ga_prefix":"123121","title":"这些真实故事改编的电影，看起来才最带劲"},{"images":["http://pic2.zhimg.com/32ec26349107b002cdb3a768f1aa3c5d.jpg"],"type":0,"id":7682199,"ga_prefix":"123119","title":"参加一场比赛就要至少休息四场，不过他们还是能拿顶级薪水"},{"images":["http://pic3.zhimg.com/d83cc3565989602cef1292cfac876106.jpg"],"type":0,"id":7681785,"ga_prefix":"123118","title":"新手怎么处理汽车交通事故，防止被坑？"},{"images":["http://pic4.zhimg.com/e4c6330ec4de350a37ec60e10f615113.jpg"],"type":0,"id":7681907,"ga_prefix":"123117","title":"年终特别篇，日报 2015 年度颁奖典礼"},{"images":["http://pic3.zhimg.com/9d7879f422b67cad81e72b446e5db646.jpg"],"type":0,"id":7591448,"ga_prefix":"123117","title":"按住别放，蓄力\u2014\u2014，一个大招必杀"},{"images":["http://pic2.zhimg.com/6f13bc4a0a2452994cb226b8e5257e0d.jpg"],"type":0,"id":7673146,"ga_prefix":"123116","title":"洗漱完躺床上，一边捏着肚腩肉，一边吃了包猪肉脯"},{"images":["http://pic4.zhimg.com/165e993e26af762318902aadacc8f717.jpg"],"type":0,"id":7676991,"ga_prefix":"123115","title":"不看完电影片尾就走的人不会知道这些故事和亮点"},{"images":["http://pic3.zhimg.com/75bd18d818b3c4d56ddbefe5191e53ee.jpg"],"type":0,"id":7677895,"ga_prefix":"123114","title":"买过最失败的东西：全家整年积蓄换来 7 寸黑白屏「电脑」怪物"},{"title":"做个水果挞吧，没有女朋友也可以送爸妈吃呀","ga_prefix":"123113","images":["http://pic3.zhimg.com/8d3891f93529928a9edeae75c7cfdc1e.jpg"],"multipic":true,"type":0,"id":7608101},{"images":["http://pic4.zhimg.com/3bc61eef0d7ad1a63a3e73556f4032b3.jpg"],"type":0,"id":7680414,"ga_prefix":"123112","title":"十分钟学一大堆终身受用的小技能"},{"images":["http://pic2.zhimg.com/61d1f05b8bafa81f66650a365d063725.jpg"],"type":0,"id":7678729,"ga_prefix":"123111","title":"黄马褂只能男性穿，有没有女款「黄马裙」？"},{"images":["http://pic1.zhimg.com/9e0e97b1d31bc5500bc1e183c7bbf9a4.jpg"],"type":0,"id":7658461,"ga_prefix":"123110","title":"放大、放大、再放大，每一株都有无数个珊瑚虫"},{"images":["http://pic3.zhimg.com/9a03cc7ab50905ea50e9539864217916.jpg"],"type":0,"id":7677616,"ga_prefix":"123109","title":"一朵伪装成各种奇怪样子的云，喜欢看你惊讶的脸"},{"images":["http://pic1.zhimg.com/d22d3198bd8037e07f380b46b2e724d0.jpg"],"type":0,"id":7676828,"ga_prefix":"123108","title":"大家都说要保护的「知识产权」，有可能不合理吗？"},{"title":"很多人质疑 iPad Pro，我来谈谈各种应用优缺点和使用感受","ga_prefix":"123107","images":["http://pic2.zhimg.com/8aa2de384c35ef2241aae0f8698219b9.jpg"],"multipic":true,"type":0,"id":7675440},{"images":["http://pic2.zhimg.com/8c1b0f9905a0477de65f0af52933a7ed.jpg"],"type":0,"id":7629729,"ga_prefix":"123107","title":"2015 年的并购案如此精彩，真的不考虑拍成电影吗"},{"images":["http://pic1.zhimg.com/d4e037df57b4a0177812f0e8b72ae954.jpg"],"type":0,"id":7677428,"ga_prefix":"123107","title":"6 大「财务造假」事件，贡献了今年业内人 90% 以上的心理阴影面积"},{"images":["http://pic1.zhimg.com/8acafa463ecabb00aaf053a102a982f0.jpg"],"type":0,"id":7671291,"ga_prefix":"123106","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    /**
     * images : ["http://pic4.zhimg.com/85f9acd1e6a6855a8c18a686a6a9e58b.jpg"]
     * type : 0
     * id : 7571431
     * ga_prefix : 123122
     * title : 深夜惊奇 · 性格大变
     */

    private List<StoriesBean> stories;

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
}
