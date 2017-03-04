package demo.rxjavaretorfitdemo.model;

import java.util.List;

/**
 * @author liuml
 * @explain  本来可以返回这个对象的  但是 服务器不按照标准格式返回我这里没法转换
 * @time 2017/3/2 17:48
 */

public class ResPonseWrap {

    /**
     * couponSend : {}
     * totalNumber : 24
     * data : [{"id":101627,"title":"中国重汽HOWO 牵引车 $$2015年 123匹 4×2","titleStr":"中国重汽HOWO 牵引车 2015年 123匹 4×2","seecName":"","areaname":"济宁市任城区","showmileage":"11.0","updatetime":"2017-02-27 13:57:21","price":"13.0","imgThumbnail":"http://7xo98k.com1.z0.glb.clouddn.com/0_wx1488173702_7987553.jpg","guarantee":"","ableloan":"0","userTypeStr":"商家","detect":"2","carstatus":"2","pricesmyb":"","firsthand":"1","brandName":"中国重汽","seriesName":"HOWO","curprice":"0.0","needcheck":"2","downPayment":"2.6","createtime":"2017-02-27 01:39:15","checktime":"2017-02-27 01:54:27","tradeTime":null,"state":null},{"id":100571,"title":"东风天锦 牵引车 $$2016年 3匹 4×2","titleStr":"东风天锦 牵引车 2016年 3匹 4×2","seecName":"","areaname":"北京市东城区","showmileage":"2.0","updatetime":"2016-12-29 15:07:52","price":"1.2","imgThumbnail":"http://7xo98k.com1.z0.glb.clouddn.com/0_ios161117100216_4367722.jpg","guarantee":"","ableloan":"0","userTypeStr":"个人","detect":"2","carstatus":"2","pricesmyb":"","firsthand":"1","brandName":"东风","seriesName":"天锦","curprice":"0.0","needcheck":"2","downPayment":"0.24","createtime":"2016-11-17 10:03:07","checktime":"2016-11-22 10:41:44","tradeTime":null,"state":null},{"id":101377,"title":"华菱星凯马 牵引车 $$2013年 1110匹 8×2","titleStr":"华菱星凯马 牵引车 2013年 1110匹 8×2","seecName":"","areaname":"北京市朝阳区","showmileage":"6.0","updatetime":"2017-02-14 13:50:22","price":"36.0","imgThumbnail":"http://7xo98k.com1.z0.glb.clouddn.com/0_ios170210141411_5059242.jpg","guarantee":"","ableloan":"0","userTypeStr":"个人","detect":"0","carstatus":"2","pricesmyb":"","firsthand":"1","brandName":"华菱","seriesName":"星凯马","curprice":"0.0","needcheck":"0","downPayment":"","createtime":"2017-02-10 02:16:04","checktime":"","tradeTime":null,"state":null},{"id":101093,"title":"华菱星凯马 牵引车 $$2011年 77匹 6×2","titleStr":"华菱星凯马 牵引车 2011年 77匹 6×2","seecName":"","areaname":"北京市顺义区","showmileage":"3767.0","updatetime":"2017-01-05 16:37:32","price":"36.0","imgThumbnail":"http://7xo98k.com1.z0.glb.clouddn.com/0_ios170105153603_4367415.jpg","guarantee":"","ableloan":"0","userTypeStr":"商家","detect":"2","carstatus":"2","pricesmyb":"","firsthand":"1","brandName":"华菱","seriesName":"星凯马","curprice":"0.0","needcheck":"2","downPayment":"7.2","createtime":"2017-01-05 03:34:49","checktime":"2017-01-05 04:37:32","tradeTime":null,"state":null},{"id":101482,"title":"沃尔沃新FM 牵引车 $$2016年 350匹 6×2","titleStr":"沃尔沃新FM 牵引车 2016年 350匹 6×2","seecName":"","areaname":"济宁市任城区","showmileage":"36.0","updatetime":"2017-02-14 15:02:34","price":"15.1","imgThumbnail":"http://7xo98k.com1.z0.glb.clouddn.com/0_ios170213174753_5074208.jpg","guarantee":"","ableloan":"0","userTypeStr":"商家","detect":"4","carstatus":"3","pricesmyb":"","firsthand":"1","brandName":"沃尔沃","seriesName":"新FM","curprice":"0.0","needcheck":"4","downPayment":"3.02","createtime":"2017-02-13 05:48:58","checktime":"2017-02-14 02:41:33","tradeTime":null,"state":null}]
     * resCode : 1
     * resMsg : 查询成功
     * totalPages : 5
     */

    private CouponSendBean couponSend;
    private int totalNumber;
    private String resCode;
    private String resMsg;
    private int totalPages;
    private List<DataBean> data;

    public CouponSendBean getCouponSend() {
        return couponSend;
    }

    public void setCouponSend(CouponSendBean couponSend) {
        this.couponSend = couponSend;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class CouponSendBean {
    }

    public static class DataBean {
        /**
         * id : 101627
         * title : 中国重汽HOWO 牵引车 $$2015年 123匹 4×2
         * titleStr : 中国重汽HOWO 牵引车 2015年 123匹 4×2
         * seecName :
         * areaname : 济宁市任城区
         * showmileage : 11.0
         * updatetime : 2017-02-27 13:57:21
         * price : 13.0
         * imgThumbnail : http://7xo98k.com1.z0.glb.clouddn.com/0_wx1488173702_7987553.jpg
         * guarantee :
         * ableloan : 0
         * userTypeStr : 商家
         * detect : 2
         * carstatus : 2
         * pricesmyb :
         * firsthand : 1
         * brandName : 中国重汽
         * seriesName : HOWO
         * curprice : 0.0
         * needcheck : 2
         * downPayment : 2.6
         * createtime : 2017-02-27 01:39:15
         * checktime : 2017-02-27 01:54:27
         * tradeTime : null
         * state : null
         */

        private int id;
        private String title;
        private String titleStr;
        private String seecName;
        private String areaname;
        private String showmileage;
        private String updatetime;
        private String price;
        private String imgThumbnail;
        private String guarantee;
        private String ableloan;
        private String userTypeStr;
        private String detect;
        private String carstatus;
        private String pricesmyb;
        private String firsthand;
        private String brandName;
        private String seriesName;
        private String curprice;
        private String needcheck;
        private String downPayment;
        private String createtime;
        private String checktime;
        private Object tradeTime;
        private Object state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitleStr() {
            return titleStr;
        }

        public void setTitleStr(String titleStr) {
            this.titleStr = titleStr;
        }

        public String getSeecName() {
            return seecName;
        }

        public void setSeecName(String seecName) {
            this.seecName = seecName;
        }

        public String getAreaname() {
            return areaname;
        }

        public void setAreaname(String areaname) {
            this.areaname = areaname;
        }

        public String getShowmileage() {
            return showmileage;
        }

        public void setShowmileage(String showmileage) {
            this.showmileage = showmileage;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImgThumbnail() {
            return imgThumbnail;
        }

        public void setImgThumbnail(String imgThumbnail) {
            this.imgThumbnail = imgThumbnail;
        }

        public String getGuarantee() {
            return guarantee;
        }

        public void setGuarantee(String guarantee) {
            this.guarantee = guarantee;
        }

        public String getAbleloan() {
            return ableloan;
        }

        public void setAbleloan(String ableloan) {
            this.ableloan = ableloan;
        }

        public String getUserTypeStr() {
            return userTypeStr;
        }

        public void setUserTypeStr(String userTypeStr) {
            this.userTypeStr = userTypeStr;
        }

        public String getDetect() {
            return detect;
        }

        public void setDetect(String detect) {
            this.detect = detect;
        }

        public String getCarstatus() {
            return carstatus;
        }

        public void setCarstatus(String carstatus) {
            this.carstatus = carstatus;
        }

        public String getPricesmyb() {
            return pricesmyb;
        }

        public void setPricesmyb(String pricesmyb) {
            this.pricesmyb = pricesmyb;
        }

        public String getFirsthand() {
            return firsthand;
        }

        public void setFirsthand(String firsthand) {
            this.firsthand = firsthand;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getSeriesName() {
            return seriesName;
        }

        public void setSeriesName(String seriesName) {
            this.seriesName = seriesName;
        }

        public String getCurprice() {
            return curprice;
        }

        public void setCurprice(String curprice) {
            this.curprice = curprice;
        }

        public String getNeedcheck() {
            return needcheck;
        }

        public void setNeedcheck(String needcheck) {
            this.needcheck = needcheck;
        }

        public String getDownPayment() {
            return downPayment;
        }

        public void setDownPayment(String downPayment) {
            this.downPayment = downPayment;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getChecktime() {
            return checktime;
        }

        public void setChecktime(String checktime) {
            this.checktime = checktime;
        }

        public Object getTradeTime() {
            return tradeTime;
        }

        public void setTradeTime(Object tradeTime) {
            this.tradeTime = tradeTime;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }
    }
}
