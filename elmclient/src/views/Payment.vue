<template>
    <div class="wrapper">
        <!-- header部分 -->
        <header>
            <p>在线支付</p>
        </header>

        <!-- 订单信息部分 -->
        <h3>订单信息：</h3>
        <div class="order-info">
            <p>
                {{ orders.business.businessName }}
                <i class="fa fa-caret-down" @click="detailetShow"></i>
            </p>
            <p>&#165;{{ orders.orderTotal }}</p>
        </div>

        <!-- 订单明细部分 -->
        <ul class="order-detailet" v-show="isShowDetailet">
            <li v-for="item in orders.list">
                <p>{{ item.food.foodName }} x {{ item.quantity }}</p>
                <p>
                    &#165;{{ (item.food.foodPrice * item.quantity).toFixed(2) }}
                </p>
            </li>
            <li>
                <p>配送费</p>
                <p>&#165;{{ orders.business.deliveryPrice }}</p>
            </li>
        </ul>

        <!-- 支付方式部分 -->
        <ul class="payment-type">
            <li @click="alipay(true)">
                <img src="../assets/alipay.png" />
                <p>
                    支付宝
                    <i class="fa fa-check-circle" v-show="isalipay"></i>
                </p>
            </li>
            <li @click="alipay(false)">
                <img src="../assets/wechat.png" />
                <p>
                    微信支付
                    <i class="fa fa-check-circle" v-show="!isalipay"></i>
                </p>
            </li>
        </ul>
        <div class="payment-button">
            <button @click="toQR">确认支付</button>
        </div>

        <!-- 底部菜单部分 -->
        <Footer></Footer>
    </div>
</template>

<script>
import Footer from "../components/Footer.vue";

export default {
    name: "Payment",
    data() {
        return {
            user: {},
            orderId: this.$route.query.orderId,
            orders: {
                business: {},
            },
            isShowDetailet: false,
            isalipay: true,
            pointDetail: {
                userId: "",
                point: 0,
                date: "",
            },
            token: "",
            config: {},
        };
    },
    created() {
        this.user = this.$getSessionStorage("user");
        this.token = this.$getSessionStorage("token");
        this.config = { headers: { token: this.token } };

        this.$axios
            .get(`orders/${this.orderId}`, this.config)
            .then((response) => {
                this.orders = response.data;
            })
            .catch((error) => {
                console.error(error);
            });
    },
    mounted() {
        //这里的代码是实现：一旦路由到在线支付组件就不能回到订单确认组件
        //先将当前路由添加到history对象中
        history.pushState(null, null, document.URL);
        //popstate事件能够监听history对象的变化
        window.onpopstate = () => {
            this.$router.push({ path: "/index" });
        };
    },
    destroyed() {
        window.onpopstate = null;
    },
    methods: {
        detailetShow() {
            this.isShowDetailet = !this.isShowDetailet;
        },
        alipay(n) {
            this.isalipay = n;
        },
        toQR() {
            if (this.isalipay == true) {
                this.$router.push({ path: "/zfbpay" });
            } else {
                this.$router.push({ path: "/wechatpay" });
            }
            this.updateOrder();
            this.savePoints();
        },
        updateOrder() {
            this.$axios
                .get(`orders/update/${this.orderId}`, this.config)
                .catch((error) => {
                    console.error(error);
                });
        },
        savePoints() {
            var date = new Date();
            var year = date.getFullYear();
            var dateArr = [
                date.getMonth() + 1,
                date.getDate(),
                date.getHours(),
                date.getMinutes(),
                date.getSeconds(),
            ];
            var strDate =
                year +
                "/" +
                dateArr[0] +
                "/" +
                dateArr[1] +
                " " +
                dateArr[2] +
                ":" +
                dateArr[3] +
                ":" +
                dateArr[4];

            this.pointDetail.userId = this.user.userId;
            this.pointDetail.point = this.orders.orderTotal * 100;
            this.pointDetail.date = strDate;
            this.$axios.post(`points/add`, this.pointDetail, this.config).catch((error) => {
                console.error(error);
            });
        },
    },
    components: {
        Footer,
    },
};
</script>

<style scoped>
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

/********** 订单信息部分 ***********/
.wrapper h3 {
    margin-top: 12vw;
    box-sizing: border-box;
    padding: 4vw 4vw 0;

    font-size: 4vw;
    font-weight: 300;
    color: #999;
}

.wrapper .order-info {
    box-sizing: border-box;
    padding: 4vw;
    font-size: 4vw;
    color: #666;

    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .order-info p:last-child {
    color: orangered;
}

/********** 订单明细部分 **********/
.wrapper .order-detailet {
    width: 100%;
}

.wrapper .order-detailet li {
    width: 100%;
    box-sizing: border-box;
    padding: 1vw 4vw;

    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .order-detailet li p {
    font-size: 3vw;
    color: #666;
}

/********** 支付方式部分 **********/
.wrapper .payment-type {
    width: 100%;
    box-sizing: border-box;
    padding: 1vw 0;
}

.wrapper .payment-type li {
    width: 100%;
    box-sizing: border-box;
    padding: 4vw;

    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .payment-type li img {
    width: 33vw;
    height: 8.1vw;
}

.wrapper .payment-type li p {
    width: 100%;
    box-sizing: border-box;
    padding: 4.5vw;
    font-size: 4.5vw;
    color: #666;

    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .payment-type li p .fa-check-circle {
    font-size: 5vw;
    color: #38ca73;
}

.wrapper .payment-button {
    width: 100%;
    box-sizing: border-box;
    padding: 4vw;
}

.wrapper .payment-button button {
    width: 100%;
    height: 10vw;
    border: none;
    outline: none;
    border-radius: 4px;
    background-color: #38ca73;
    color: #ffffff;
}
</style>
