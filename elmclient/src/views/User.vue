<template>
    <div class="wrapper">
        <header>我的</header>
        <div class="user">
            <div class="user-img">
                <img src="../assets/userImg/user.jpg" />
            </div>
            <div class="user-info">
                <h3>{{ user.userName }}</h3>
                <p>{{ user.userId }}</p>
            </div>

            <div class="user-points">
                <div class="member">
                    <div class="member-state"><i class="fa fa-lock" />未成为会员</div>
                    <div class="member-info">下单获增吃货豆，豆兑万物更实惠。</div>
                </div>
                <div class="chd">
                    <p class="text">
                        吃货豆
                        <p class="points">{{ totalPoints }}</p>
                    </p>
                </div>
            </div>

            <div class="VIP">
                <div class="left">
                    <img src="../assets/VIP.png" />
                    <h3>超级会员</h3>
                    <p>&#8226; 每月享超级权益</p>
                </div>
                <div class="right">立即开通 &gt;</div>
            </div>
        </div>

        <div class="tools">
        <p class="tools-title">常见工具</p>
            <ul>
                <li @click="toAddress">
                    <i class="fa fa-map-marker" />
                    <p>我的地址</p>
                </li>
                <li>
                    <i class="fa fa-headphones" />
                   <p>我的客服</p>
                </li>
                <li>
                    <i class="fa fa-heart-o" />
                    <p>店铺关注</p>
                </li>
                <li>
                    <i class="fa fa-star-o" />
                    <p>评价有礼</p>
                </li>
                <li>
                    <i class="fa fa-exclamation-circle" />
                    <p>用户协议</p>
                </li>
                <li>
                    <i class="fa fa-eye-slash" />
                    <p>隐私政策</p>
                </li>
                <li @click="toOrderList">
                    <i class="fa fa-file-text-o" />
                <p>我的账单</p>
                </li>
                <li>
                    <i class="fa fa-commenting-o" />
                    <p>消息中心</p>
                </li>
            
            </ul>
        </div>

        <Footer></Footer>
    </div>
</template>

<script>
import Footer from "../components/Footer.vue";
export default {
    name: "User",
    data() {
        return {
            user: {},
            totalPoints: 0,
        };
    },
    created() {
        this.user = this.$getSessionStorage("user");
        this.loadTotalPoints();
    },
    methods: {
        loadTotalPoints() {
            this.$axios
                .post(
                    "UserController/getTotalPoints",
                    this.$qs.stringify({
                        userId: this.user.userId,
                    })
                )
                .then((response) => {
                    this.totalPoints = response.data;
                })
                .catch((error) => {
                    console.error(error);
                });
        },
        toOrderList() {
				this.$router.push({
					path: '/orderList'
				});
		},
        toAddress() {
				this.$router.push({
					path: '/userAddress'
				});
		},
    },
    components: {
        Footer,
    },
};
</script>

<style scoped>
.wrapper {
    width: 100%;
    height: 100%;
    user-select: none;
    background-color: #f5f5f5;
}
.wrapper header {
    width: 100%;
    height: 12vw;
    background-color: #0097ff;
    color: #fff;
    font-size: 4.8vw;
    position: fixed;
    left: 0;
    top: 0;
    z-index: 1000;
    display: flex;
    justify-content: center;
    align-items: center;
}
.wrapper .user {
    width: 100%;
    padding-top: 12vw;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    align-content: center;
}
.wrapper .user .user-img {
    position: relative;
    padding-top: 6vw;
    margin-left: 3vw;
}
.wrapper .user .user-img img {
    width: 40vw;
    height: 40vw;
    border-radius: 50vw;
}
.wrapper .user .user-info {
    margin-right: 6vw;
    margin-top: 15vw;
}
.wrapper .user .user-info h3 {
    font-size: 10vw;
    color: #555;
}
.wrapper .user .user-info p {
    font-size: 4vw;
    color: #888;
    margin-top: 2vw;
}
.wrapper .user .user-points {
    width: 95%;
    border-radius: 7px;
    margin-top: 6vw;
    padding-top: 2vw;
    padding-bottom: 2vw;
    background-color: #3e4555;
    display: flex;
    justify-content: space-around;
    align-items: center;
}
.wrapper .user .user-points .member {
    padding-top: 2vw;
    padding-bottom: 2vw;
}
.wrapper .user .user-points .member .member-state{
    background-color: #e0e0e0;
    padding: 1vw;
    margin-bottom: 3vw;
    border-radius: 7px;
    display: inline-block;
    font-size: 3vw;
    font-weight: bold;
    color: #3e4555;
}
.wrapper .user .user-points .member .member-state i {
    padding-right: 1vw;
}
.wrapper .user .user-points .member .member-info{
    font-size: 3vw;
    color: #8b91a3;
}
.wrapper .user .user-points .chd {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.wrapper .user .user-points .chd .text {
    font-size: 3vw;
    color: #8b91a3;
}
.wrapper .user .user-points .chd .points {
    font-size: 6vw;
    color: #b9bece;
}
.wrapper .VIP {
    width: 95%;
    margin: 0 auto;
    height: 11.5vw;
    background-color: #feedc1;
    margin-top: 1.3vw;
    border-radius: 7px;
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
    cursor: pointer;
}
.wrapper .tools {
    width: 95%;
    margin: 0 auto;
    margin-top: 1.3vw;
    border-radius: 7px;
    padding-top: 2vw;
    padding-bottom: 2vw;
    background-color: #ffffff;


}
.wrapper .tools .tools-title {
    font-size: 5vw;
    font-weight: bold;
    color: #666;
    margin-bottom: 2vw;
    margin-top: 2vw;
    margin-left: 4vw;
}
.wrapper .tools ul {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    align-content: center;
}
.wrapper .tools li {
    width: 23vw;
    height: 25vw;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    user-select: none;
    cursor: pointer;
}
.wrapper .tools li i {
    font-size: 8vw;
    color: #666;
    margin-bottom: 1vw;
}
.wrapper .tools li p {
    font-size: 3.2vw;
    color: #666;
}
</style>
