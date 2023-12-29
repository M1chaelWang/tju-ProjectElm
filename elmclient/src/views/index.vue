<template>
  <div class="wrapper">
    <!-- header -->
    <header>
      <div class="icon-location-box">
        <div class="icon-location"></div>
      </div>
      <div class="location-text">
        天津大学智能与计算学部<i class="fa fa-caret-down"></i>
      </div>
    </header>
    <!-- search -->
    <div class="search">
      <div class="search-fixed-top" ref="fixedBox">
        <div class="search-box">
          <i class="fa fa-search"></i>搜索饿了么商家、商品名称
        </div>
      </div>
    </div>

    <!-- 点餐分类 -->
    <ul class="foodtype">
      <li @click="toBusinessList(1)">
        <img src="../assets/dcfl01.png" />
        <p>美食</p>
      </li>
      <li @click="toBusinessList(2)">
        <img src="../assets/dcfl02.png" />
        <p>早餐</p>
      </li>
      <li @click="toBusinessList(3)">
        <img src="../assets/dcfl03.png" />
        <p>跑腿代购</p>
      </li>
      <li @click="toBusinessList(4)">
        <img src="../assets/dcfl04.png" />
        <p>汉堡披萨</p>
      </li>
      <li @click="toBusinessList(5)">
        <img src="../assets/dcfl05.png" />
        <p>甜品 饮品</p>
      </li>
      <li @click="toBusinessList(6)">
        <img src="../assets/dcfl06.png" />
        <p>速食简餐</p>
      </li>
      <li @click="toBusinessList(7)">
        <img src="../assets/dcfl07.png" />
        <p>地方小吃</p>
      </li>
      <li @click="toBusinessList(8)">
        <img src="../assets/dcfl08.png" />
        <p>米粉面馆</p>
      </li>
      <li @click="toBusinessList(9)">
        <img src="../assets/dcfl09.png" />
        <p>包子粥铺</p>
      </li>
      <li @click="toBusinessList(10)">
        <img src="../assets/dcfl10.png" />
        <p>炸鸡炸串</p>
      </li>
    </ul>

    <!-- 广告 -->
    <div class="banner">
      <h3>品质套餐</h3>
      <p>搭配齐全吃得好</p>
      <a>立刻抢购 &gt;</a>
    </div>

    <!-- VIP -->
    <div class="VIP">
      <div class="left">
        <img src="../assets/VIP.png" />
        <h3>超级会员</h3>
        <p>&#8226; 每月享超级权益</p>
      </div>
      <div class="right">立即开通 &gt;</div>
    </div>

    <!-- 推荐商家 -->
    <div class="recommend">
      <div class="recommend-line"></div>
      <p>推荐商家</p>
      <div class="recommend-line"></div>
    </div>

    <!-- 推荐方式 -->
    <ul class="recommendtype">
      <li>综合排序<i class="fa fa-caret-down"></i></li>
      <li>距离最近</li>
      <li>销量最高</li>
      <li>筛选<i class="fa fa-filter"></i></li>
    </ul>

    <!-- 推荐商家列表 -->
    <ul class="business">
      <li>
        <img src="../assets/sj01.png" />
        <div class="business-info">
          <div class="business-info-h">
            <h3>万家饺子（软件园E18店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>3.9 月售345单</p>
            </div>
            <div class="business-info-star-right">蜂鸟专送</div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>3.22km | 30分钟</p>
          </div>
          <div class="business-info-explain">
            <div>各种饺子炒菜</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>两个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div
                class="business-info-promotion-left-icon"
                style="background-color: #f1884f"
              >
                特
              </div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>

      <li>
        <img src="../assets/sj02.png" />
        <div class="business-info">
          <div class="business-info-h">
            <h3>小锅饭豆腐馆（全运店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>3.6 月售233单</p>
            </div>
            <div class="business-info-star-right">蜂鸟专送</div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>4.21km | 42分钟</p>
          </div>
          <div class="business-info-explain">
            <div>特色美食</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>两个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div
                class="business-info-promotion-left-icon"
                style="background-color: #f1884f"
              >
                特
              </div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/sj03.png" />
        <div class="business-info">
          <div class="business-info-h">
            <h3>麦当劳麦乐送（全运路店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.8 月售562单</p>
            </div>
            <div class="business-info-star-right">蜂鸟专送</div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>2.10km | 20分钟</p>
          </div>
          <div class="business-info-explain">
            <div>汉堡薯条</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>两个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div
                class="business-info-promotion-left-icon"
                style="background-color: #f1884f"
              >
                特
              </div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/sj04.png" />
        <div class="business-info">
          <div class="business-info-h">
            <h3>米村拌饭（浑南店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>3.1 月售145单</p>
            </div>
            <div class="business-info-star-right">蜂鸟专送</div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>4.11km | 35分钟</p>
          </div>
          <div class="business-info-explain">
            <div>各种炒菜拌饭</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>两个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div
                class="business-info-promotion-left-icon"
                style="background-color: #f1884f"
              >
                特
              </div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/sj05.png" />
        <div class="business-info">
          <div class="business-info-h">
            <h3>申记串道（中海康城店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>3.0 月售300单</p>
            </div>
            <div class="business-info-star-right">蜂鸟专送</div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>2.15km | 20分钟</p>
          </div>
          <div class="business-info-explain">
            <div>烤串炸串</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>两个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div
                class="business-info-promotion-left-icon"
                style="background-color: #f1884f"
              >
                特
              </div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/sj06.png" />
        <div class="business-info">
          <div class="business-info-h">
            <h3>半亩良田排骨米饭</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.0 月售410单</p>
            </div>
            <div class="business-info-star-right">蜂鸟专送</div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>5.25km | 50分钟</p>
          </div>
          <div class="business-info-explain">
            <div>排骨米饭套餐</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>两个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div
                class="business-info-promotion-left-icon"
                style="background-color: #f1884f"
              >
                特
              </div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
      <li>
        <img src="../assets/sj07.png" />
        <div class="business-info">
          <div class="business-info-h">
            <h3>茶兮鲜果饮品（国际软件园店）</h3>
            <div class="business-info-like">&#8226;</div>
          </div>
          <div class="business-info-star">
            <div class="business-info-star-left">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <p>4.2 月售500单</p>
            </div>
            <div class="business-info-star-right">蜂鸟专送</div>
          </div>
          <div class="business-info-delivery">
            <p>&#165;15起送 | &#165;3配送</p>
            <p>1.50km | 15分钟</p>
          </div>
          <div class="business-info-explain">
            <div>甜品饮品</div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div class="business-info-promotion-left-icon">新</div>
              <p>饿了么新用户首单立减9元</p>
            </div>
            <div class="business-info-promotion-right">
              <p>两个活动</p>
              <i class="fa fa-caret-down"></i>
            </div>
          </div>
          <div class="business-info-promotion">
            <div class="business-info-promotion-left">
              <div
                class="business-info-promotion-left-icon"
                style="background-color: #f1884f"
              >
                特
              </div>
              <p>特价商品5元起</p>
            </div>
          </div>
        </div>
      </li>
    </ul>
    <!-- 底部菜单 -->
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from "../components/Footer.vue";

export default {
  name: "Index",
  components: {
    Footer,
  },
  mounted() {
    this.handleScroll = () => {
      const s1 = document.documentElement.scrollTop;
      const s2 = document.body.scrollTop;
      const scroll = s1 === 0 ? s2 : s1;
      const width = document.documentElement.clientWidth;
      const search = this.$refs.fixedBox;

      if (scroll > width * 0.12) {
        search.style.position = "fixed";
        search.style.left = "0";
        search.style.top = "0";
      } else {
        search.style.position = "static";
      }
    };

    document.addEventListener("scroll", this.handleScroll);
  },
  beforeUnmount() {
    document.removeEventListener("scroll", this.handleScroll);
  },
  methods: {
    toBusinessList(orderTypeId) {
      this.$router.push({
        path: "/businessList/",
        query: {
          orderTypeId: orderTypeId,
        },
      });
    },
  },
};
</script>

<style scoped>
.icon-location {
  position: relative;
  width: 100%;
  height: 100%;
  border-radius: 50% 50% 50% 0;
  background: #fff;
  transform: rotate(-45deg);
}
.icon-location:after {
  content: "";
  width: 40%;
  height: 40%;
  margin: 30% 0 0 29%;
  background-color: #0097ff;
  position: absolute;
  border-radius: 50%;
}
/********** 总容器 **********/
.wrapper {
  width: 100%;
  height: 100%;
}

/********** header **********/
.wrapper header {
  width: 100%;
  height: 12vw;
  background-color: #0097ff;

  display: flex;
  align-items: center;
}

.wrapper header .icon-location-box {
  width: 3.5vw;
  height: 3.5vw;
  margin: 0 1vw 0 3vw;
}

.wrapper header .location-text {
  font-size: 4.5vw;
  font-weight: 100;
  color: #fff;
}

.wrapper header .location-text .fa-caret-down {
  margin-left: 1vw;
}

/*********** search **********/
.wrapper .search {
  width: 100%;
  height: 13vw;
}

.wrapper .search .search-fixed-top {
  width: 100%;
  height: 13vw;
  background-color: #0097ff;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .search .search-fixed-top .search-box {
  width: 90%;
  height: 9vw;
  background-color: #fff;
  border-radius: 2px;
  display: flex;
  justify-content: center;
  align-items: center;
  font: 3.5vw;
  color: #aeaeae;
  font-family: "宋体";
  user-select: none;
}

.wrapper .search .search-fixed-top .search-box .fa-search {
  margin-right: 1vw;
}

/*************点餐分类************/
.wrapper .foodtype {
  width: 100%;
  height: 48vw;

  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  align-content: center;
}

.wrapper .foodtype li {
  width: 18vw;
  height: 20vw;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  user-select: none;
  cursor: pointer;
}

.wrapper .foodtype li img {
  width: 12vw;
  height: 12vw;
}

.wrapper .foodtype li p {
  font-size: 3.2vw;
  color: #666;
}

/********* 广告 **********/
.wrapper .banner {
  width: 95%;
  margin: 0 auto;
  height: 29vw;
  background-image: url(../assets/index_banner.png);
  background-repeat: no-repeat;
  background-size: cover;
  box-sizing: border-box;
  padding: 2vw 6vw;
}

.wrapper .banner h3 {
  font-size: 4.2vw;
  margin-bottom: 1.2vw;
  user-select: none;
}

.wrapper .banner p {
  font-size: 3.4vw;
  color: #666;
  margin-bottom: 2.4vw;
  user-select: none;
}

.wrapper .banner a {
  font-size: 3vw;
  color: #c79060;
  cursor: pointer;
  font-weight: 700;
  user-select: none;
}

/***********vip**********/
.wrapper .VIP {
  width: 95%;
  margin: 0 auto;
  height: 11.5vw;
  background-color: #feedc1;
  margin-top: 1.3vw;
  border-radius: 2px;
  color: #644f18;

  display: flex;
  justify-content: space-around;
  align-items: center;
}

.wrapper .VIP .left {
  display: flex;
  align-items: center;
  margin-left: 4vw;
  user-select: none;
}

.wrapper .VIP .left img {
  width: 6vw;
  height: 6vw;
  margin-right: 2vw;
}

.wrapper .VIP .left h3 {
  font-size: 4vw;
  margin-right: 2vw;
}

.wrapper .VIP .left p {
  font-size: 3vw;
}

.wrapper .VIP .right {
  font-size: 3vw;
  margin-right: 4vw;
  user-select: none;
  cursor: pointer;
}

/******** 推荐商家*********/
.wrapper .recommend {
  width: 100%;
  height: 14vw;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .recommend .recommend-line {
  width: 6vw;
  height: 0.2vw;
  background-color: #888;
}

.wrapper .recommend p {
  font-size: 4vw;
  margin: 0 4vw;
}

/********* 推荐方式 ********/
.wrapper .recommendtype {
  width: 100%;
  height: 5vw;
  margin-bottom: 5vw;

  display: flex;
  justify-content: space-around;
  align-items: center;
}

.wrapper .recommendtype li {
  font-size: 3.5vw;
  color: #555;
}

/********推荐商家列表***********/
.wrapper .business {
  width: 100%;
  padding-bottom: 14vw;
}

.wrapper .business li {
  width: 100%;
  box-sizing: border-box;
  padding: 2.5vw;
  user-select: none;
  border-bottom: solid 1px #ddd;
  display: flex;
}

.wrapper .business li img {
  width: 18vw;
  height: 18vw;
}

.wrapper .business li .business-info {
  width: 100%;
  box-sizing: border-box;
  padding-left: 3vw;
}

.wrapper .business li .business-info .business-info-h {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2vw;
}

.wrapper .business li .business-info .business-info-h h3 {
  font-size: 4vw;
  color: #333;
}

.wrapper .business li .business-info .business-info-h .business-info-like {
  width: 1.6vw;
  height: 3.4vw;
  background-color: #666;
  color: #fff;
  font-size: 4vw;
  margin-right: 4vw;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .business li .business-info .business-info-star {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2vw;
  font-size: 3.1vw;
}

.wrapper
  .business
  li
  .business-info
  .business-info-star
  .business-info-star-left {
  display: flex;
  align-items: center;
}

.wrapper
  .business
  li
  .business-info
  .business-info-star
  .business-info-star-left
  .fa-star {
  color: #fec80e;
  margin-right: 0.5vw;
}

.wrapper
  .business
  li
  .business-info
  .business-info-star
  .business-info-star-left
  p {
  color: #666;
  margin-left: 1vw;
}

.wrapper
  .business
  li
  .business-info
  .business-info-star
  .business-info-star-right {
  background-color: #0097ff;
  color: #fff;
  font-size: 2.4vw;
  border-radius: 2px;
  padding: 0 0.6vw;
}

.wrapper .business li .business-info .business-info-delivery {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2vw;
  color: #666;
  font-size: 3.1vw;
}

.wrapper .business li .business-info .business-info-explain {
  display: flex;
  align-items: center;
  margin-bottom: 3vw;
}

.wrapper .business li .business-info .business-info-explain div {
  border: solid 1px #ddd;
  font-size: 2.8vw;
  color: #666;
  border-radius: 3px;
  padding: 0 0.1vw;
}

.wrapper .business li .business-info .business-info-promotion {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 1.8vw;
}

.wrapper
  .business
  li
  .business-info
  .business-info-promotion
  .business-info-promotion-left {
  display: flex;
  align-items: center;
}

.wrapper
  .business
  li
  .business-info
  .business-info-promotion
  .business-info-promotion-left
  .business-info-promotion-left-icon {
  width: 4vw;
  height: 4vw;
  background-color: #70bc46;
  border-radius: 3px;
  font-size: 3vw;
  color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper
  .business
  li
  .business-info
  .business-info-promotion
  .business-info-promotion-left
  p {
  color: #666;
  font-size: 3vw;
  margin-left: 2vw;
}

.wrapper
  .business
  li
  .business-info
  .business-info-promotion
  .business-info-promotion-right {
  display: flex;
  align-items: center;
  font-size: 2.5vw;
  color: #999;
}

.wrapper
  .business
  li
  .business-info
  .business-info-promotion
  .business-info-promotion-right
  p {
  margin-right: 2vw;
}
</style>
